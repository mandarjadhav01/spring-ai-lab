package com.spring.ai.lab.rag.retrieval;

import com.spring.ai.lab.rag.model.RetrievalStrategy;
import org.springframework.stereotype.Service;

@Service
public class RetrievalStrategyResolver {

    public RetrievalStrategy resolve(String query) {
        String normalized = query.toLowerCase();

        if(normalized.length() < 25) {
            return RetrievalStrategy.CORRECTIVE;
        }

        if(normalized.contains(" and ") || normalized.contains(" or ")) {
            return RetrievalStrategy.MULTI_QUERY;
        }

        return RetrievalStrategy.DEFAULT;
    }
}
