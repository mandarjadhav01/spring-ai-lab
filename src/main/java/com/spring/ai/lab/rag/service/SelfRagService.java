package com.spring.ai.lab.rag.service;

import com.spring.ai.lab.rag.dto.ChatResponse;
import com.spring.ai.lab.rag.dto.RetrievalRequest;
import com.spring.ai.lab.rag.graph.GraphRagEnrichmentService;
import com.spring.ai.lab.rag.model.RetrievalResult;
import com.spring.ai.lab.rag.model.RetrievalStrategy;
import com.spring.ai.lab.rag.query.QueryRewritingService;
import com.spring.ai.lab.rag.retrieval.MultiQueryRetrievalService;
import com.spring.ai.lab.rag.retrieval.RetrievalFallbackService;
import com.spring.ai.lab.rag.retrieval.RetrievalService;
import com.spring.ai.lab.rag.retrieval.RetrievalStrategyResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelfRagService {
    private final RetrievalService retrievalService;
    private final QueryRewritingService  queryRewritingService;
    private final PromptOrchestrationService promptOrchestrationService;
    private final AnswerEvaluationService  answerEvaluationService;
    private final ChatClient chatClient;
    private final RetrievalFallbackService retrievalFallbackService;
    private final RetrievalStrategyResolver retrievalStrategyResolver;
    private final MultiQueryRetrievalService multiQueryRetrievalService;
    private final GraphRagEnrichmentService graphRagEnrichmentService;

    public ChatResponse generateAnswer(String query) {
        log.info("SELF-RAG: Initial retrieval started");

        RetrievalStrategy retrievalStrategy = retrievalStrategyResolver.resolve(query);
        log.info("Adaptive Retrieval Strategy Selected: {} ", retrievalStrategy);

        RetrievalRequest retrievalRequest = new RetrievalRequest();
        retrievalRequest.setQuery(query);

        List<RetrievalResult> retrievalResults = retrieve(query, retrievalStrategy);
        if(isWeakRetrieval(retrievalResults)) {
            log.info("CORRECTIVE-RAG: Weak retrieval detected. Applying retrieval fallback strategies.");
            retrievalResults = retrievalFallbackService.retrieve(query);
        }

        String answer = generateAnswerFromResults(query, retrievalResults);
        log.info("ANSWER: {}", answer);

        boolean weakAnswer = answerEvaluationService.isWeakAnswer(answer, retrievalResults);

        if (!weakAnswer) {
            log.info("SELF-RAG: Initial answer accepted");
            List<String> sources = retrievalResults.stream()
                    .map(result ->
                            (String) result.getMetadata().get("source")
                    )
                    .distinct()
                    .toList();
            return new ChatResponse(answer, sources);
        }

        log.info("SELF-RAG: Weak answer detected. Retrying retrieval.");

        String retryQuery = queryRewritingService.rewrite(query);
        log.info("SELF-RAG: Rewritten query: {}", retryQuery);

        RetrievalRequest retryRequest = new RetrievalRequest();

        retryRequest.setQuery(retryQuery);

        List<RetrievalResult> retryResults = retrievalService.retrieve(retryRequest);

        String improvedAnswer = generateAnswerFromResults(query, retryResults);
        log.info("IMPROVED ANSWER: {}", improvedAnswer);
        List<String> sources = retryResults.stream()
                .map(result ->
                        (String) result.getMetadata().get("source")
                )
                .distinct()
                .toList();

        return new ChatResponse(improvedAnswer, sources);
    }

    private List<RetrievalResult> retrieve(String query, RetrievalStrategy retrievalStrategy) {

        return switch (retrievalStrategy) {
            case CORRECTIVE -> retrievalFallbackService.retrieve(query);
            case MULTI_QUERY -> multiQueryRetrievalService.retrieve(query);
            default -> {
                RetrievalRequest request = new RetrievalRequest();
                request.setQuery(query);
                yield retrievalService.retrieve(request);
            }
        };
    }


    private boolean isWeakRetrieval(List<RetrievalResult> results) {
        if(results.isEmpty()) {
            return true;
        }
        Double score = results.get(0).getFinalScore();
        return score == null || score < 0.9;
    }

    private String generateAnswerFromResults(String query, List<RetrievalResult> retrievalResults) {
        String prompt = promptOrchestrationService.buildPrompt(query, retrievalResults);

        String graphContext = graphRagEnrichmentService.buildGraphContext(retrievalResults);
        if(!graphContext.isBlank()) {
            prompt += """
                    
                    Graph Context: 
                    %s
                    """.formatted(graphContext);
        }
        log.info("FINAL PROMPT: \n{}", prompt);

        return chatClient.prompt().user(prompt).call().content();
    }
}












