package com.spring.ai.lab.rag.controller;

import com.spring.ai.lab.rag.dto.ChatRequest;
import com.spring.ai.lab.rag.dto.ChatResponse;
import com.spring.ai.lab.rag.services.ChatService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }

}
