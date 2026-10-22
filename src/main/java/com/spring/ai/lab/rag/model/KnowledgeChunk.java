package com.spring.ai.lab.rag.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class KnowledgeChunk {
    private String chunkId;
    private String documentId;
    private SourceType sourceType;
    private String source;
    private String content;
    private Map<String, Object> metadata;
    private int chunkIndex;
}
