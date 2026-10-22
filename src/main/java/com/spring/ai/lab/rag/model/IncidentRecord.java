package com.spring.ai.lab.rag.model;

public record IncidentRecord(String incidentId,
                             String title,
                             String severity,
                             String affectedServices) {
}
