package com.spring.ai.lab.rag.ingestion;


import com.spring.ai.lab.rag.model.KnowledgeDocument;
import com.spring.ai.lab.rag.model.SourceType;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.ParagraphPdfDocumentReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

@Service
@Slf4j
public class PdfIngestionService {

    private static final Path DATA_PATH = Path.of("data");
    private static final Path DOCUMENTS_PATH = DATA_PATH.resolve("documents");
    private static final Path REPORTS_PATH = DATA_PATH.resolve("reports");

    public List<KnowledgeDocument> loadPolicyDocuments() {
        return loadDocuments(DOCUMENTS_PATH);
    }

    public List<KnowledgeDocument> loadReports() {
        return loadDocuments(REPORTS_PATH);
    }

    public List<KnowledgeDocument> loadDocuments(Path rootPath) {

        try (Stream<Path> pathStream = Files.walk(rootPath)) {
            return pathStream
                    .filter(Files::isRegularFile)
                    .filter(this::isPdfFile)
                    .map(this::toKnowledgeDocument)
                    .flatMap(List::stream)
                    .toList();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return Collections.emptyList();
    }

    private List<KnowledgeDocument> toKnowledgeDocument(Path path) {
        ParagraphPdfDocumentReader pdfReader = new ParagraphPdfDocumentReader(path.toAbsolutePath().toString());
        List<Document> documents = pdfReader.read();
        List<KnowledgeDocument> knowledgeDocuments = new ArrayList<>();
        for (Document paragraph : documents) {
            knowledgeDocuments.add(new KnowledgeDocument(
                    UUID.randomUUID().toString(),
                    paragraph.getText(),
                    path.toAbsolutePath().toString(),
                SourceType.PDF,
                Map.of("fileName", path.getFileName(), "contentLength", paragraph.getText().length())
        ));

        }
        return knowledgeDocuments;

    }


    private boolean isPdfFile(Path path) {
        return path.toString().endsWith(".pdf");
    }

}
