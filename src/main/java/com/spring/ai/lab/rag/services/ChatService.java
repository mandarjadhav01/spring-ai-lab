package com.spring.ai.lab.rag.services;

import com.spring.ai.lab.rag.chunking.model.Chunk;
import com.spring.ai.lab.rag.dto.ChatRequest;
import com.spring.ai.lab.rag.dto.ChatResponse;
import com.spring.ai.lab.rag.prompt.PromptOrchestrator;
import com.spring.ai.lab.rag.prompt.model.ChatPrompt;
import com.spring.ai.lab.rag.retrieval.RetrievalService;
import com.spring.ai.lab.rag.retrieval.model.RetrievalResult;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

    private final PromptOrchestrator promptOrchestrator;

    public ChatResponse chat(ChatRequest request) {
        String userMessage = request.getMessage();

        ChatPrompt chatPrompt = promptOrchestrator.build(userMessage);

        String llmInput = chatPrompt.getGroundingRule()
                + "\n\n"
                + chatPrompt.getContext().getContextText()
                + "\n\nUser Question:\n"
                + userMessage;

        String aiResponse = chatClient.prompt()
                .system(chatPrompt.getSystemInstructions().getInstructions())
                .user(llmInput)
                .call().content();

        return new ChatResponse(aiResponse);
    }
}
