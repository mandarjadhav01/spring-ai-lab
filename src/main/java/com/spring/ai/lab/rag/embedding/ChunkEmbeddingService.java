package com.spring.ai.lab.rag.embedding;

import com.spring.ai.lab.rag.chunking.model.Chunk;
import com.spring.ai.lab.rag.embedding.model.EmbeddedChunk;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChunkEmbeddingService {

    private final EmbeddingModel embeddingModel;

    public EmbeddedChunk embed(Chunk chunk) {
        float[] vector = embeddingModel.embed(chunk.getContent());
        return new EmbeddedChunk(chunk, vector);
    }

}
