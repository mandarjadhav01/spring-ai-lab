package com.spring.ai.lab.rag.retrieval;

import com.spring.ai.lab.rag.dto.RetrievalRequest;
import com.spring.ai.lab.rag.model.RetrievalResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class HybridSearchService {

    private final RetrievalService retrievalService;
    private final KeywordSearchService keywordSearchService;
    private final RerankingService rerankingService;

    public List<RetrievalResult> search(RetrievalRequest request) {
        List<RetrievalResult> vectorResults = retrievalService.retrieve(request);

        List<RetrievalResult> keywordResults = keywordSearchService.search(request.getQuery());

        Map<String, RetrievalResult> mergedResults = new LinkedHashMap<>();

        for(RetrievalResult result : vectorResults) {
            mergedResults.put(result.getContent(), result);
        }
        for(RetrievalResult result : keywordResults) {
            RetrievalResult existing =  mergedResults.get(result.getContent());

            if(existing != null) {
                Double combinedScore = existing.getFinalScore() + result.getFinalScore();
                existing.setFinalScore(combinedScore);
                existing.setRetrievalType("HYBRID");
            } else {
                mergedResults.put(result.getContent(), result);
            }
        }
        List<RetrievalResult> results = new ArrayList<>(mergedResults.values());
        results.sort(Comparator.comparing(RetrievalResult::getFinalScore).reversed());
        return rerankingService.rerank(results);
    }
}
