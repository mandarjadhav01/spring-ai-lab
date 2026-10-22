package com.spring.ai.lab.rag.service;

import com.spring.ai.lab.rag.model.RetrievalResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptOrchestrationService {

    private static final int MAX_CONTEXT_RESULTS = 3;

    public String buildPrompt(String query, List<RetrievalResult> results) {
        StringBuilder contextBuilder = new StringBuilder();

        int addedCount = 0;

        for(RetrievalResult result: results) {
            if(addedCount >= MAX_CONTEXT_RESULTS) {
                break;
            }

            String source = (String) result.getMetadata().get("source");

            contextBuilder
                    .append("SOURCE:")
                    .append(source)
                    .append("\n\n")
                    .append(result.getContent())
                    .append("\n------------------------------------------\n\n");

            addedCount++;
        }

        return """
                You are an enterprise AI assistant.
                
                Answer only using the provided context.
                
                If the answer is not present in the context, say you do not know.
                
                Context:
                %s
                
                User Question:
                %s
                
                """.formatted(contextBuilder.toString(), query);
    }
}






