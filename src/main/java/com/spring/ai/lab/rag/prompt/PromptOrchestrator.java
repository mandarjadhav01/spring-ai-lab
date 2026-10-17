package com.spring.ai.lab.rag.prompt;

import com.spring.ai.lab.rag.prompt.model.ChatPrompt;
import com.spring.ai.lab.rag.prompt.model.PromptContext;
import com.spring.ai.lab.rag.prompt.model.SystemInstructions;
import com.spring.ai.lab.rag.retrieval.RetrievalService;
import com.spring.ai.lab.rag.retrieval.model.RetrievalResult;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor 
public class PromptOrchestrator {

    private final RetrievalService retrievalService;
    private final ContextBuilder contextBuilder;
    private final SystemPromptLoader systemPromptLoader;
    private final GroundingPolicy groundingPolicy;

    public ChatPrompt build(String question) {

        RetrievalResult retrievalResult = retrievalService.retrieve(question);

        PromptContext promptContext = contextBuilder.build(retrievalResult);

        String rule = groundingPolicy.groundingRules(promptContext);

        SystemInstructions systemInstructions = systemPromptLoader.load();

        return new ChatPrompt(systemInstructions, promptContext,  rule);
    }
}
