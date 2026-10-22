package com.spring.ai.lab.rag.graph;

import com.spring.ai.lab.rag.model.IncidentRecord;
import com.spring.ai.lab.rag.model.SupportTicketRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseGraphBuilderService {

    private final JdbcTemplate jdbcTemplate;
    private final EnterpriseNodeRepository graphRepository;

    @Transactional("neo4jTransactionManager")
    public void buildGraph() {
        buildSupportTicketGraph();
        buildIncidentGraph();
    }

    private void buildIncidentGraph() {

        List<IncidentRecord> incidents =
                jdbcTemplate.query(
                        """
                                SELECT incident_id, title, severity, affected_services FROM incident_reports
                                """,
                        (rs, rowNum) ->
                                new IncidentRecord(
                                        rs.getString("incident_id"),
                                        rs.getString("title"),
                                        rs.getString("severity"),
                                        rs.getString("affected_services")
                                )
                );

        for(IncidentRecord incident: incidents) {
            EnterpriseNode incidentNode = createNode(incident.incidentId(), "INCIDENT", incident.title());
            EnterpriseNode severityNode = createNode(incident.severity(), "SEVERITY", incident.severity());
            EnterpriseNode serviceNode = createNode(incident.affectedServices(), "SERVICE", incident.affectedServices());

            addRelationship(incidentNode, severityNode, "HAS_SEVERITY");
            addRelationship(incidentNode, serviceNode, "AFFECTS");
            graphRepository.save(incidentNode);
        }

    }

    private void buildSupportTicketGraph() {
        List<SupportTicketRecord> tickets = jdbcTemplate.query(
                """ 
                            SELECT ticket_id, title, assigned_team, environment FROM support_tickets
                        """,
                (rs, rowNum) ->
                        new SupportTicketRecord(
                                rs.getString("ticket_id"),
                                rs.getString("title"),
                                rs.getString("assigned_team"),
                                rs.getString("environment")
                        )
        );

        for(SupportTicketRecord ticket: tickets) {
            EnterpriseNode ticketNode = createNode(ticket.ticketId(), "TICKET", ticket.title());
            EnterpriseNode teamNode = createNode(ticket.assignedTeam(), "TEAM", ticket.assignedTeam());
            EnterpriseNode  environmentNode = createNode(ticket.environment(), "ENVIRONMENT", ticket.environment());

            addRelationship(ticketNode, teamNode, "ASSIGNED_TO");
            addRelationship(ticketNode, environmentNode, "OCCURRED_IN");
            graphRepository.save(ticketNode);
        }
    }

    private void addRelationship(EnterpriseNode source, EnterpriseNode target, String relationshipType) {
        EnterpriseRelationship relationship = new EnterpriseRelationship();
        relationship.setRelationshipType(relationshipType);
        relationship.setTarget(target);
        source.getRelationships().add(relationship);
    }

    private EnterpriseNode createNode(String entityId, String entityType, String name) {
        return graphRepository.findByEntityId(entityId)
                .orElseGet(() -> {

                    EnterpriseNode node = new EnterpriseNode();
                    node.setEntityId(entityId);
                    node.setEntityType(entityType);
                    node.setName(name);
                    return graphRepository.save(node);
                });
    }
}












