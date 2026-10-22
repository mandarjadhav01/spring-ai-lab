package com.spring.ai.lab.rag.graph;

import com.spring.ai.lab.rag.model.RetrievalResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GraphRagEnrichmentService {
    private final GraphEntityResolver entityResolver;
    private final GraphContextService graphContextService;

    public String buildGraphContext(List<RetrievalResult> retrievalResults) {
        Set<String> entityIds = entityResolver.resolveEntityIds(retrievalResults);

        if(entityIds.isEmpty()){
            return "";
        }

        List<EnterpriseNode> nodes = graphContextService.getGraphContext(entityIds);
        StringBuilder context = new StringBuilder();
        for(EnterpriseNode node : nodes){
            context.append(node.getEntityType())
                    .append(": ")
                    .append(node.getName())
                    .append("\n");

            node.getRelationships().forEach(rel -> {
                context.append(" - ").append(rel.getRelationshipType())
                        .append(" -> ")
                        .append(rel.getTarget().getName())
                        .append("\n");
            });
        }
        return context.toString();
    }
}
