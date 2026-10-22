package com.spring.ai.lab.rag.retrieval;

import com.spring.ai.lab.rag.dto.RetrievalRequest;
import com.spring.ai.lab.rag.model.RetrievalResult;
import com.spring.ai.lab.rag.security.TenantContext;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrievalService {

    private final VectorStore vectorStore;

    public List<RetrievalResult> retrieve(RetrievalRequest request) {

        SearchRequest.Builder builder = SearchRequest.builder()
                .query(request.getQuery())
                .topK(3);

        List<String> filters = new ArrayList<>();

        if(request.getSourceType() != null) {
            filters.add("sourceType == '" + request.getSourceType() + "'");
        }

        if(request.getEnvironment() != null) {
            filters.add("environment == '" + request.getEnvironment() + "'");
        }

        String tenantId = TenantContext.getTenant();
        if(tenantId != null) {
            filters.add("tenantId == '" + tenantId + "'");
        }

        filters.add("containsPii != true");

        if(!filters.isEmpty()) {
            builder.filterExpression(String.join(" && ", filters));
        }

        List<Document> documents = vectorStore.similaritySearch(builder.build());

        List<RetrievalResult> results = new ArrayList<>();
        for(Document document: documents) {
            RetrievalResult result = new RetrievalResult();
            result.setContent(document.getText());
            result.setMetadata(document.getMetadata());

            Object distance = document.getMetadata().get("distance");
            if(distance instanceof Number number) {
                result.setScore(number.doubleValue());

                result.setFinalScore(1.0 - result.getScore());
            }
            result.setRetrievalType("VECTOR");
            results.add(result);
        }
        return results;
    }
}
