package com.spring.ai.lab.rag.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditLogRepository auditLogRepository;

    public void logQuery(String userId, String tenantId, String query,
                         List<String> sources, boolean success) {

        AuditLogEntity entity = AuditLogEntity.builder()
                .id(UUID.randomUUID())
                .timestamp(LocalDateTime.now())
                .userId(userId)
                .tenantId(tenantId)
                .query(query)
                .retrievedSources(sources.toArray(new String[0]))
                .responseStatus(success ? "SUCCESS" : "FAILED")
                .build();

        auditLogRepository.save(entity);
    }
}
