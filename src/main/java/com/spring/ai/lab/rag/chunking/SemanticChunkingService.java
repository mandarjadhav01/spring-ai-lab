package com.spring.ai.lab.rag.chunking;

import com.spring.ai.lab.rag.model.KnowledgeChunk;
import com.spring.ai.lab.rag.model.KnowledgeDocument;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SemanticChunkingService {

    private final Parser parser;

    public SemanticChunkingService() {
        this.parser = Parser.builder().build();
    }

    public List<KnowledgeChunk> chunkDocument(KnowledgeDocument document) {
        List<KnowledgeChunk> chunks = new ArrayList<>();

        Document markdownDocument = parser.parse(document.getContent());
        List<Heading> headings = extractHeadings(markdownDocument);

        for (int i = 0; i < headings.size(); i++) {
            Heading currentHeading = headings.get(i);
            Heading nextHeading = null;

            if (i + 1 < headings.size()) {
                nextHeading = headings.get(i + 1);
            }
            String chunkContent = extractSectionContent(currentHeading, nextHeading);

            KnowledgeChunk chunk = KnowledgeChunk.builder()
                    .chunkId(UUID.randomUUID().toString())
                    .documentId(document.getDocumentId())
                    .sourceType(document.getSourceType())
                    .source(document.getSource())
                    .content(chunkContent)
                    .chunkIndex(i)
                    .metadata(document.getMetadata())
                    .build();
            chunks.add(chunk);
        }

        return chunks;
    }

    private String extractSectionContent(Heading currentHeading, Heading nextHeading) {
        StringBuilder content = new StringBuilder();
        Node node = currentHeading;

        while (node != null && node != nextHeading) {
            content.append(node.getChars()).append("\n");
            node = node.getNext();
        }
        return content.toString();
    }

    private List<Heading> extractHeadings(Document document) {
        List<Heading> headings = new ArrayList<>();
        Node node = document.getFirstChild();

        while (node != null) {
            if (node instanceof Heading heading) {
                headings.add(heading);
            }
            node = node.getNext();
        }
        return headings;
    }
}








