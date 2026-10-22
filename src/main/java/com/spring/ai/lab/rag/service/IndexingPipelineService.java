package com.spring.ai.lab.rag.service;

import com.spring.ai.lab.rag.chunking.ChunkingOrchestrator;
import com.spring.ai.lab.rag.ingestion.IngestionOrchestrator;
import com.spring.ai.lab.rag.model.KnowledgeChunk;
import com.spring.ai.lab.rag.model.KnowledgeDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexingPipelineService {
    private final IngestionOrchestrator ingestionOrchestrator;
    private final ChunkingOrchestrator chunkingOrchestrator;
    private final VectorStoreService vectorStoreService;

    public void indexAll() {
        List<KnowledgeDocument> documents = ingestionOrchestrator.ingestAll();

        List<KnowledgeChunk> allChunks = new ArrayList<>();
        for (KnowledgeDocument document : documents) {
            allChunks.addAll(chunkingOrchestrator.chunkDocument(document));
        }

        vectorStoreService.storeChunks(allChunks);
    }
}

