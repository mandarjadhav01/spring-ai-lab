package com.spring.ai.lab.rag.graph;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Data
@Node("EnterpriseEntity")
public class EnterpriseNode {
    @Id
    @GeneratedValue
    private Long id;

    private String entityId;

    private String entityType;

    private String name;

    @Relationship(type="RELATED_TO")
    private Set<EnterpriseRelationship> relationships = new HashSet<>();

}
