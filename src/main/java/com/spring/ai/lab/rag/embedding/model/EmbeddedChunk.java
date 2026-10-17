package com.spring.ai.lab.rag.embedding.model;


import com.spring.ai.lab.rag.chunking.model.Chunk;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmbeddedChunk {
    private final Chunk chunk;
    private final float[] vector;
}
