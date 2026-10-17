package com.spring.ai.lab.rag.prompt.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatPrompt {
    private final SystemInstructions systemInstructions;
    private final PromptContext context;
    private final String groundingRule;
}
