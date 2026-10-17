package com.spring.ai.lab.rag.lifecycle;

import com.spring.ai.lab.rag.chunking.ChunkingOrchestrator;
import com.spring.ai.lab.rag.chunking.model.Chunk;
import com.spring.ai.lab.rag.lifecycle.model.KnowledgeRequest;
import com.spring.ai.lab.rag.services.ingestion.IngestionOrchestrator;
import com.spring.ai.lab.rag.services.ingestion.model.IngestedDocument;
import com.spring.ai.lab.rag.vectorstore.ChunkVectorStoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgeLifecycleService {
    private final ChunkVectorStoreService vectorStoreService;
    private final IngestionOrchestrator ingestionOrchestrator;
    private final ChunkingOrchestrator chunkingOrchestrator;

    public void ingest(KnowledgeRequest request) throws Exception {
        String identity = KnowledgeIdentity.from(request);
        vectorStoreService.deleteByIdentity(identity);

        List<IngestedDocument> documents = ingestionOrchestrator.ingest(request);
        List<Chunk> chunksToStore = new ArrayList<>();
        for (IngestedDocument document : documents) {
            List<Chunk> chunks = chunkingOrchestrator.chunk(document);
            chunksToStore.addAll(chunks);
        }
        vectorStoreService.store(chunksToStore);
    }

    public void delete(KnowledgeRequest request) {
        String identity = KnowledgeIdentity.from(request);
        vectorStoreService.deleteByIdentity(identity);
    }

    public void ingestAll() throws Exception {
        deleteAll();

        List<IngestedDocument> documents = ingestionOrchestrator.ingestAll();
        List<Chunk> chunksToStore = new ArrayList<>();
        for (IngestedDocument document : documents) {
            List<Chunk> chunks = chunkingOrchestrator.chunk(document);
            chunksToStore.addAll(chunks);
        }
        vectorStoreService.store(chunksToStore);
    }

    public void deleteAll() {
        vectorStoreService.deleteAll();
    }

}
