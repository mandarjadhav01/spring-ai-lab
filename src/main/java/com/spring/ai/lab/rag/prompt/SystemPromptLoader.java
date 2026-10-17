package com.spring.ai.lab.rag.prompt;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.spring.ai.lab.rag.prompt.model.SystemInstructions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component 
public class SystemPromptLoader {

    private static final String SYSTEM_PROMPT_PATH = "prompts/system-prompt.st";

    public SystemInstructions load() {
        try {
            ClassPathResource resource = new ClassPathResource(SYSTEM_PROMPT_PATH);

            String prompt = new String(
                    resource.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );
            return new SystemInstructions(prompt);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to load system prompt from " + SYSTEM_PROMPT_PATH, ex);
        }
    }
}
