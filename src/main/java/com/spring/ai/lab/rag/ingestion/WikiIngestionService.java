package com.spring.ai.lab.rag.ingestion;

import com.spring.ai.lab.rag.model.KnowledgeDocument;
import com.spring.ai.lab.rag.model.SourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Slf4j
public class WikiIngestionService {

    private static final Path DATA_PATH = Path.of("data");
    private static final Path WIKI_PATH = DATA_PATH.resolve("wiki-repo");

    public List<KnowledgeDocument> loadDocuments() {

        try (Stream<Path> pathStream = Files.walk(WIKI_PATH)) {

            return pathStream
                    .filter(Files::isRegularFile)
                    .filter(this::isMarkdownFile)
                    .map(this::toKnowledgeDocument)
                    .toList();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();

    }

    private KnowledgeDocument toKnowledgeDocument(Path path) {
        try {
            String content = Files.readString(path);

            String relativeSource = DATA_PATH
                    .relativize(path)
                    .toString().replace("\\", "/");

            return new KnowledgeDocument(
                    UUID.randomUUID().toString(),
                    content,
                    relativeSource,
                    SourceType.MARKDOWN,
                    Map.of("fileName", path.getFileName().toString(), "contentLength", content.length())
            );

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    private boolean isMarkdownFile(Path path) {
        return path.toString().endsWith(".md");
    }



}
