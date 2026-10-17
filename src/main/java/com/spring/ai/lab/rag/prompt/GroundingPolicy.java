package com.spring.ai.lab.rag.prompt;

import org.springframework.stereotype.Component;

import com.spring.ai.lab.rag.prompt.model.PromptContext;

@Component 
public class GroundingPolicy {

    public String groundingRules(PromptContext context) {

        if (context == null || context.getContextText().isBlank()) {
            return """
                   You do not have sufficient information to answer the question.
                   Respond clearly that you do not know.
                   Do not guess or infer.
                   """;
        }

        return """
               Answer the user's question using ONLY the provided context.
               If the answer is not present in the context, say that you do not know.
               Do not use prior knowledge.
               """;
    }
}
