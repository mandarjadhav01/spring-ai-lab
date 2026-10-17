package com.spring.ai.lab.rag.prompt.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SystemInstructions {
    private final String instructions;
}
