package com.spring.ai.lab.rag.chunking;

import com.spring.ai.lab.rag.model.KnowledgeChunk;
import com.spring.ai.lab.rag.model.KnowledgeDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class FixedSizeChunkingService {

    private static final int CHUNK_SIZE = 1000;

    public List<KnowledgeChunk> chunkDocument(KnowledgeDocument document) {
        List<KnowledgeChunk> chunks = new ArrayList<>();
        String content = document.getContent();
        int chunkIndex = 0;

        for (int start = 0; start < content.length(); start += CHUNK_SIZE) {
            int end = Math.min(start + CHUNK_SIZE, content.length());

            String chunkContent = content.substring(start, end);
            KnowledgeChunk chunk = KnowledgeChunk.builder()
                    .chunkId(UUID.randomUUID().toString())
                    .documentId(document.getDocumentId())
                    .content(chunkContent)
                    .sourceType(document.getSourceType())
                    .source(document.getSource())
                    .chunkIndex(chunkIndex)
                    .metadata(document.getMetadata())
                    .build();

            chunks.add(chunk);
            chunkIndex++;
        }

        return chunks;
    }
}
