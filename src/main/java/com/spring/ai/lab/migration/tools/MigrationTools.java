package com.spring.ai.lab.migration.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Spring AI @Tool suite providing safe sandboxed filesystem access, OpenRewrite execution,
 * and Gradle compilation/integration test verification for the self-healing migration loop.
 *
 * Reference: https://docs.spring.io/spring-ai/reference/api/tools.html
 */
@Component
@Slf4j
public class MigrationTools {


    private static final Pattern COMPILER_ERROR_PATTERN =
            Pattern.compile("(?m)^(.+\\.java):(\\d+):\\s+error:\\s+(.+)$");

    private final Path legacyRoot;
    private final Path targetWorkspaceRoot;

    public MigrationTools(
            @Value("${migration.paths.legacy-root:./legacy}") String legacyRootPath,
            @Value("${migration.paths.target-root:./target-spring-boot4}") String targetWorkspacePath) {
        this.legacyRoot = Path.of(legacyRootPath).toAbsolutePath().normalize();
        this.targetWorkspaceRoot = Path.of(targetWorkspacePath).toAbsolutePath().normalize();
    }

    @Tool(description = "Lists all Java EE legacy EJB, JNDI, and Hibernate DAO files in the legacy directory to identify micro-slices.")
    public List<String> listLegacyFiles() throws IOException {
        if (!Files.exists(legacyRoot)) {
            return List.of();
        }
        try (Stream<Path> walk = Files.walk(legacyRoot)) {
            return walk.filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java") || p.toString().endsWith(".xml"))
                    .map(p -> legacyRoot.relativize(p).toString())
                    .sorted()
                    .toList();
        }
    }

    @Tool(description = "Reads content from the legacy code subdirectory safely with path-traversal protection.")
    public String readLegacyFile(
            @ToolParam(description = "Relative path inside ./legacy/, e.g. 'auth/UserAuthSessionBean.java'") String path)
            throws IOException {
        Path resolved = legacyRoot.resolve(path).normalize();
        if (!resolved.startsWith(legacyRoot)) {
            throw new SecurityException("Access denied: Path traversal outside ./legacy/ is prohibited.");
        }
        if (!Files.exists(resolved)) {
            return "ERROR: Legacy file not found at ./legacy/" + path;
        }
        return Files.readString(resolved);
    }

    @Tool(description = "Writes generated Spring Boot 4.x production or test code (Modulith domain, Spring Data JPA Repository, @RestController, RestTestClient/WebTestClient test) to the target project.")
    public String writeMigratedFile(
            @ToolParam(description = "Relative file path in target Spring Boot 4.x project, e.g. 'src/main/java/com/app/auth/web/UserAuthController.java'") String relativePath,
            @ToolParam(description = "Complete Java source content to write") String content) throws IOException {
        Path resolved = targetWorkspaceRoot.resolve(relativePath).normalize();
        if (!resolved.startsWith(targetWorkspaceRoot)) {
            throw new SecurityException("Access denied: Cannot write outside target workspace.");
        }
        Files.createDirectories(resolved.getParent());
        Files.writeString(resolved, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        log.info("Wrote migrated file: {}", resolved);
        return "SUCCESS: Wrote " + relativePath + " (" + content.lines().count() + " lines)";
    }

    @Tool(description = "Executes OpenRewrite recipes to automatically update Java versions, Jakarta namespaces, and Spring Boot 4.x dependencies.")
    public String runOpenRewriteRecipe(
            @ToolParam(description = "Fully qualified OpenRewrite recipe name, e.g. 'org.openrewrite.java.spring.boot4.UpgradeSpringBoot_4_0'") String recipeName) {
        log.info("Executing OpenRewrite recipe: {}", recipeName);
        return executeGradleCommand(
                List.of("./gradlew", "rewriteRun", "-Drewrite.activeRecipe=" + recipeName, "--no-daemon"),
                Duration.ofMinutes(3),
                "OpenRewrite execution successful for recipe: " + recipeName
        );
    }

    @Tool(description = "Compiles the generated Spring Boot 4.x application and runs RestTestClient/WebTestClient integration tests, returning structured line-by-line compiler or test diagnostics if it fails.")
    public String verifyBuild() {
        log.info("Running verifyBuild() on target Spring Boot 4.x workspace...");
        return executeGradleCommand(
                List.of("./gradlew", "compileJava", "compileTestJava", "test", "--no-daemon", "--console=plain"),
                Duration.ofMinutes(4),
                "BUILD SUCCESSFUL"
        );
    }

    private String executeGradleCommand(List<String> command, Duration timeout, String successMessage) {
        File workDir = targetWorkspaceRoot.toFile();
        if (!workDir.exists()) {
            return "WORKSPACE_ERROR: Target directory does not exist: " + targetWorkspaceRoot;
        }
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(workDir);
        pb.redirectErrorStream(true);

        StringBuilder rawOutput = new StringBuilder();
        try {
            Process process = pb.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    rawOutput.append(line).append(System.lineSeparator());
                }
            }
            boolean finished = process.waitFor(timeout.toSeconds(), TimeUnit.SECONDS);
            if (!finished) {
                process.destroyForcibly();
                return "BUILD FAILED: Command timed out after " + timeout.toSeconds() + "s.\n" + rawOutput;
            }
            if (process.exitValue() == 0) {
                return successMessage;
            }
            return formatSelfHealingDiagnostics(rawOutput.toString());
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return "BUILD FAILED: Process execution exception: " + e.getMessage();
        }
    }

    /**
     * Parses javac and JUnit output into actionable self-healing feedback, e.g.:
     * "The compilation failed with symbol missing on line 42 in UserAuthController.java: cannot find symbol"
     */
    public String formatSelfHealingDiagnostics(String compilerOutput) {
        StringBuilder summary = new StringBuilder("BUILD FAILED. Self-Healing Diagnostic Report:\n");
        Matcher matcher = COMPILER_ERROR_PATTERN.matcher(compilerOutput);
        int count = 0;
        while (matcher.find()) {
            count++;
            String file = Path.of(matcher.group(1)).getFileName().toString();
            String line = matcher.group(2);
            String message = matcher.group(3);
            summary.append(String.format(
                    "- Compilation failed on line %s in %s: %s%n", line, file, message));
        }
        if (count == 0) {
            // Fallback to last 40 lines of stack trace / test failure output
            String tail = compilerOutput.lines()
                    .skip(Math.max(0, compilerOutput.lines().count() - 40))
                    .collect(Collectors.joining("\n"));
            summary.append(tail);
        } else {
            summary.append("\nRaw Compiler Snippet:\n").append(compilerOutput);
        }
        return summary.toString();
    }
}