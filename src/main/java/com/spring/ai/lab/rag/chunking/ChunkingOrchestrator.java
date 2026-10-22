package com.spring.ai.lab.rag.chunking;

import com.spring.ai.lab.rag.model.KnowledgeChunk;
import com.spring.ai.lab.rag.model.KnowledgeDocument;
import com.spring.ai.lab.rag.model.SourceType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChunkingOrchestrator {

    private final FixedSizeChunkingService  fixedSizeChunkingService;
    private final OverlapChunkingService overlapChunkingService;
    private final SemanticChunkingService  semanticChunkingService;
    private final DatabaseChunkingService databaseChunkingService;

    public List<KnowledgeChunk> chunkDocument(KnowledgeDocument document) {

        SourceType sourceType = document.getSourceType();

        return switch(sourceType) {
            case MARKDOWN -> semanticChunkingService.chunkDocument(document);
            case PDF -> overlapChunkingService.chunkDocument(document);
            case DATABASE -> databaseChunkingService.chunkDocument(document);
            case IMAGE -> overlapChunkingService.chunkDocument(document);

            default -> fixedSizeChunkingService.chunkDocument(document);
        };
    }
}
