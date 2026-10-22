package com.spring.ai.lab.rag.graph;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GraphContextService {
    private final EnterpriseNodeRepository repository;

    public List<EnterpriseNode> getGraphContext(Collection<String> entityIds) {
        return repository.findGraphContext(entityIds);
    }
}
