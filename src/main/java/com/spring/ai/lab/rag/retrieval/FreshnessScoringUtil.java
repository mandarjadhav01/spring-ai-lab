package com.spring.ai.lab.rag.retrieval;

import java.time.Duration;
import java.time.LocalDateTime;

public class FreshnessScoringUtil {

    public static double calculateBoost(LocalDateTime updatedAt) {
        if(updatedAt == null) return 0.0;

        long daysOld = Duration.between(updatedAt, LocalDateTime.now()).toDays();

        if(daysOld <= 7) {
            return 0.15;
        }

        if(daysOld <= 30) {
            return 0.10;
        }

        if(daysOld <= 90) {
            return 0.05;
        }

        return 0.0;
    }

}
