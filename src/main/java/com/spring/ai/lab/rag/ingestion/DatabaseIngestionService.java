package com.spring.ai.lab.rag.ingestion;

import com.spring.ai.lab.rag.model.KnowledgeDocument;
import com.spring.ai.lab.rag.model.SourceType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DatabaseIngestionService {
    private final JdbcTemplate jdbcTemplate;

    public List<KnowledgeDocument> loadIncidentReports() {

        String sql = "SELECT * FROM incident_reports";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String incidentId = rs.getString("incident_id");

            String content = """
                    Incident ID: %s
                    
                    Title:
                    %s
                    
                    Summary:
                    %s
                    
                    Root Cause:
                    %s
                    
                    Resolution:
                    %s
                    
                    Severity:
                    %s
                    
                    Status:
                    %s
                    
                    Affected Services:
                    %s
                    """.formatted(
                    incidentId,
                    rs.getString("title"),
                    rs.getString("summary"),
                    rs.getString("root_cause"),
                    rs.getString("resolution"),
                    rs.getString("severity"),
                    rs.getString("status"),
                    rs.getString("affected_services")
                    );

            Map<String, Object> metadata = Map.of(
                    "incidentId", incidentId,
                    "severity", rs.getString("severity"),
                    "status", rs.getString("status"),
                    "affectedServices", rs.getString("affected_services"),
                    "graphEntities", List.of(
                            "INCIDENT:"+incidentId,
                            "SEVERITY:" + rs.getString("severity"),
                            "SERVICE:" + rs.getString("affected_services")
                    )
            );

            return new KnowledgeDocument(UUID.randomUUID().toString(),
                    content,
                    "incident_reports/" + incidentId,
                    SourceType.DATABASE,
                    metadata
            );
        });
    }

    public List<KnowledgeDocument> loadSupportTickets() {
        String sql = "SELECT * FROM support_tickets";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String ticketId = rs.getString("ticket_id");
            String comments = loadComments(ticketId);

            String content = """
                    Ticket ID: %s
                    
                    Title:
                    %s
                    
                    Description:
                    %s
                    
                    Status:
                    %s
                    
                    Priority:
                    %s
                    
                    Comments:
                    %s
                    
            """.formatted(ticketId,
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("priority"),
                    comments);

            Map<String, Object> metadata = Map.of(
                    "ticketId", ticketId,
                    "status", rs.getString("status"),
                    "priority", rs.getString("priority"),
                    "category", rs.getString("category"),
                    "tenantId", rs.getString("tenant_id"),
                    "environment", rs.getString("environment"),
                    "updatedAt", rs.getString("updated_at"),
                    "graphEntities", List.of(
                            "TICKET:" + ticketId,
                            "TEAM:" + rs.getString("assigned_team"),
                            "ENVIRONMENT:" + rs.getString("environment")
                    )
            );

            return new KnowledgeDocument(
                    UUID.randomUUID().toString(),
                    content,
                    "support_tickets/" + ticketId,
                    SourceType.DATABASE,
                    metadata
            );
        });
    }

    private String loadComments(String ticketId) {
        String sql = """
                SELECT comment_text
                FROM ticket_comments
                WHERE ticket_id = ?
                ORDER BY created_at
                """;
        List<String> comments = jdbcTemplate.query(
                sql,
                (rs, rowNum) -> "- " + rs.getString("comment_text"),
                ticketId
        );
        return String.join("\n", comments);
    }
}
