package com.spring.ai.lab.rag.controller;

import com.spring.ai.lab.rag.graph.EnterpriseNode;
import com.spring.ai.lab.rag.graph.GraphRetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/graphrag")
public class GraphRetrievalController {

    private final GraphRetrievalService graphRetrievalService;

    @GetMapping("/search")
    public List<EnterpriseNode> search(@RequestParam String query) {
        return graphRetrievalService.retrieve(query);
    }
}
