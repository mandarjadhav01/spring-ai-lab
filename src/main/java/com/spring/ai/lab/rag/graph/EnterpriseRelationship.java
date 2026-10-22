package com.spring.ai.lab.rag.graph;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class EnterpriseRelationship {

    @Id
    @GeneratedValue
    private Long id;

    private String relationshipType;

    @TargetNode
    private EnterpriseNode target;
}
