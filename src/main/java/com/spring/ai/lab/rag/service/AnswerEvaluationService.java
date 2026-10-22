package com.spring.ai.lab.rag.service;

import com.spring.ai.lab.rag.model.RetrievalResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AnswerEvaluationService {

    public boolean isWeakAnswer(String answer, List<RetrievalResult> retrievalResults) {
        if(answer == null || answer.isBlank()) {
            log.info("Weak answer detected: empty answer");
            return true;
        }

        if(answer.toLowerCase().contains("i do not know")) {
            log.info("Weak answer detected: fallback response");
            return true;
        }

        if(answer.length() < 80) {
            log.info("Weak answer detected: answer too short");
            return true;
        }

        if(retrievalResults.isEmpty()) {
            log.info("Weak answer detected: empty retrieval");
            return true;
        }
        return false;
    }
}
