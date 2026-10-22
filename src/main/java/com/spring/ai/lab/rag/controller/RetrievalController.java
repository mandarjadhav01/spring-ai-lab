package com.spring.ai.lab.rag.controller;

import com.spring.ai.lab.rag.dto.RetrievalRequest;
import com.spring.ai.lab.rag.model.RetrievalResult;
import com.spring.ai.lab.rag.retrieval.RetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/retrieval")
@RequiredArgsConstructor
public class RetrievalController {

    private final RetrievalService retrievalService;

    @PostMapping
    public List<RetrievalResult> retrieve(@RequestBody RetrievalRequest request) {
        return  retrievalService.retrieve(request);
    }
}
