package com.spring.ai.lab.rag.service;

import com.spring.ai.lab.rag.dto.ChatRequest;
import com.spring.ai.lab.rag.dto.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final SelfRagService selfRagService;

    @Cacheable(
            value = "chatResponses",
            key = "T(com.spring.ai.lab.rag.security.TenantContext).getTenant() + ':' + #chatRequest.message.trim().toLowerCase()"
    )
    public ChatResponse getResponse(ChatRequest chatRequest, String userId) {
        return selfRagService.generateAnswer(chatRequest.getMessage());
    }
}
