package com.spring.ai.lab.rag.graph;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GraphRetrievalService {

    private final EnterpriseNodeRepository  enterpriseNodeRepository;

    public List<EnterpriseNode> retrieve(String query) {
        return enterpriseNodeRepository.searchGraph(query);
    }
}
