package com.spring.ai.lab.rag.ingestion;

import com.spring.ai.lab.rag.model.KnowledgeDocument;
import com.spring.ai.lab.rag.model.SourceType;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@Service
public class MultimodalIngestionService {

    private static final Path DATA_PATH = Path.of("data");
    private static final Path ASSETS_PATH = DATA_PATH.resolve("assets");

    public List<KnowledgeDocument> loadDocuments() {

        try (Stream<Path> pathStream = Files.walk(ASSETS_PATH)) {

            return pathStream
                    .filter(Files::isRegularFile)
                    .filter(this::isSupportedImage)
                    .map(this::toKnowledgeDocument)
                    .toList();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    private KnowledgeDocument toKnowledgeDocument(Path path) {

        try {
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
            File imageFile = path.toFile();
            String extractedText = tesseract.doOCR(imageFile);

            String content = """
                    OCR Content:
                    %s
                    """.formatted(extractedText);

            String relativeSource = DATA_PATH
                    .relativize(path)
                    .toString()
                    .replace("\\", "/");

            Map<String,Object> metadata = Map.of(
                    "fileName", path.getFileName().toString(),
                    "contentLength", content.length(),
                    "ocr", true
            );

            return new KnowledgeDocument(
                    UUID.randomUUID().toString(),
                    content,
                    relativeSource,
                    SourceType.IMAGE,
                    metadata
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private boolean isSupportedImage(Path path) {
        String normalizedPath = path.toString()
                .replace("\\", "/")
                .toLowerCase();

        boolean supportedExtension = normalizedPath.endsWith(".png")
                || normalizedPath.endsWith(".jpg")
                || normalizedPath.endsWith(".jpeg");

        boolean supportedDirectory = normalizedPath.contains("/screenshots/")
                || normalizedPath.contains("/scanned_docs/");

        return supportedExtension && supportedDirectory;
    }
}
