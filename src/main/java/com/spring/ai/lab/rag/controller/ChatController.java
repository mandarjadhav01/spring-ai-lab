package com.spring.ai.lab.rag.controller;

import com.spring.ai.lab.rag.dto.ChatRequest;
import com.spring.ai.lab.rag.dto.ChatResponse;
import com.spring.ai.lab.rag.security.TenantContext;
import com.spring.ai.lab.rag.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String currentUser = "admin@nexacorp.com";
        //TenantContext.setTenant("TENANT_BETA");
        return chatService.getResponse(request,  currentUser);
    }

}
