package com.spring.ai.lab.rag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetrievalRequest {
    private String query;
    private String sourceType;
    private String environment;

    public RetrievalRequest(String query, String sourceType) {
        this.query = query;
        this.sourceType = sourceType;
    }
}
