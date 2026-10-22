package com.spring.ai.lab.rag.audit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "rag_audit_log")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogEntity {
    @Id
    private UUID id;

    private LocalDateTime timestamp;

    private String userId;

    private String tenantId;

    @Column(columnDefinition = "TEXT")
    private String query;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(columnDefinition = "TEXT[]")
    private String[] retrievedSources;

    private String responseStatus;
}
