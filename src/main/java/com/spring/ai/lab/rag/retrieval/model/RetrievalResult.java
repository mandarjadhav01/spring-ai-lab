package com.spring.ai.lab.rag.retrieval.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.spring.ai.lab.rag.chunking.model.Chunk;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrievalResult {

    private List<Chunk> chunks;
}
