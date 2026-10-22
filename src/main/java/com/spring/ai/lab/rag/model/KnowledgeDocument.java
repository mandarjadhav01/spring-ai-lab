package com.spring.ai.lab.rag.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class KnowledgeDocument {
    private String documentId;
    private String content;
    private String source;
    private SourceType sourceType;
    private Map<String,Object> metadata;
}

