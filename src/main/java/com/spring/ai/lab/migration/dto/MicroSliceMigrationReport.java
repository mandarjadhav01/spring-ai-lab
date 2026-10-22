package com.spring.ai.lab.migration.dto;

import java.util.List;

public record MicroSliceMigrationReport(
            String sliceName,
            boolean buildSucceeded,
            int attemptsUsed,
            String architecturalBlueprint,
            String lastCodeGenSummary,
            List<String> healingTraceLog
    ) {}