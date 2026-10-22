package com.spring.ai.lab.rag.retrieval;

import com.spring.ai.lab.rag.dto.RetrievalRequest;
import com.spring.ai.lab.rag.model.RetrievalResult;
import com.spring.ai.lab.rag.query.HyDEService;
import com.spring.ai.lab.rag.query.QueryRewritingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RetrievalFallbackService {
    private final HybridSearchService hybridSearchService;
    private final QueryRewritingService queryRewritingService;
    private final HyDEService hyDEService;

    public List<RetrievalResult> retrieve(String query) {

        log.info("STARTING RETRIEVAL FALLBACK");
        log.info("ORIGINAL QUERY: {}", query);

        RetrievalRequest request = new RetrievalRequest();
        request.setQuery(query);

        log.info("STAGE 1: HYBRID RETRIEVAL");

        List<RetrievalResult> results = hybridSearchService.search(request);

        if (!isWeakResult(results)) {
            log.info("STAGE 1 SUCCESS");
            log.info("TOP SCORE: {}", results.get(0).getFinalScore());
            return results;
        }

        log.info("STAGE 1 WEAK RESULTS");
        log.info("TOP SCORE: {}", results.get(0).getFinalScore());
        log.info("FALLING BACK TO QUERY REWRITE");

        String rewrittenQuery = queryRewritingService.rewrite(query);

        log.info("REWRITTEN QUERY: {}", rewrittenQuery);
        request.setQuery(rewrittenQuery);
        results = hybridSearchService.search(request);

        if (!isWeakResult(results)) {
            log.info("STAGE 2 SUCCESS");
            log.info("TOP SCORE: {}", results.get(0).getFinalScore());
            return results;
        }

        log.info("STAGE 2 WEAK RESULTS");
        log.info("TOP SCORE: {}", results.get(0).getFinalScore());
        log.info("FALLING BACK TO HYDE");

        String hypotheticalDocument = hyDEService.generateHypotheticalDocument(query);

        log.info("HYPOTHETICAL DOCUMENT:");
        log.info("\n{}", hypotheticalDocument);
        request.setQuery(hypotheticalDocument);

        results = hybridSearchService.search(request);

        log.info("STAGE 3 COMPLETE");
        log.info("TOP SCORE: {}", results.get(0).getFinalScore());

        return results;
    }

    private boolean isWeakResult(List<RetrievalResult> results) {
        if(results.isEmpty()) {
            return true;
        }

        Double score = results.get(0).getScore();

        return score == null || score < 0.9;
    }
}
