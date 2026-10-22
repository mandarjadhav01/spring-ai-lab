package com.spring.ai.lab.rag.graph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EnterpriseNodeRepository extends Neo4jRepository<EnterpriseNode, Long> {

    Optional<EnterpriseNode> findByEntityId(String entityId);

    @Query("""
        MATCH (n:EnterpriseEntity)-[r]->(m)
        WHERE toLower(n.name) CONTAINS toLower($query)
        RETURN n,
           collect(r) as relationships,
           collect(m) as relatedNodes
        """)
    List<EnterpriseNode> searchGraph(String query);

    @Query("""
        MATCH (n:EnterpriseEntity)-[r]->(m)
        WHERE n.entityId IN $entityIds
        RETURN n,
               collect(r) as relationships,
               collect(m) as relatedNodes
        """)
    List<EnterpriseNode> findGraphContext(Collection<String> entityIds);

}
