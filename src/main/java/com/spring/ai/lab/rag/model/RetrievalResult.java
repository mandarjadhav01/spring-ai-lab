package com.spring.ai.lab.rag.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetrievalResult {
    private String content;
    private Double score;
    private Map<String, Object> metadata;

    private String retrievalType; // VECTOR, KEYWORD, HYBRID
    private Double finalScore;
}
