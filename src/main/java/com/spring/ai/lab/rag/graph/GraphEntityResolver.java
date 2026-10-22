package com.spring.ai.lab.rag.graph;

import com.spring.ai.lab.rag.model.RetrievalResult;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GraphEntityResolver {

    public Set<String> resolveEntityIds(List<RetrievalResult> retrievalResults) {

        Set<String> entityIds = new HashSet<String>();

        for(RetrievalResult result : retrievalResults) {
            Object graphEntities = result.getMetadata().get("graphEntities");

            if(!(graphEntities instanceof List<?> entities)) {
                continue;
            }

            for(Object entity : entities) {
                String value = entity.toString();
                int index = value.indexOf(":");
                if(index>0) {
                    entityIds.add(value.substring(index + 1));
                }
            }
        }
        return entityIds;
    }
}
