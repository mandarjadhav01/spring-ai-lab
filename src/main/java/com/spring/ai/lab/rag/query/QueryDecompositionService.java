package com.spring.ai.lab.rag.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryDecompositionService {
    private final ChatClient chatClient;

    public List<String> decompose(String query) {
        String prompt = """
                Break the following enterprise search query into smaller retrieval-focused search queries.
                
                Keep each query:
                - concise
                - keyword-oriented
                - optimized for enterprise retrieval
                
                do not generate questions, explanations, bullets, or numbering.
                Return one query per line.
                
                Query:
                %s
                """.formatted(query);

        String response = chatClient.prompt().user(prompt).call().content();

        return Arrays.stream(response.split("\\R"))
                .map(String::trim)
                .filter(line -> !line.isBlank())
                .toList();
    }
}
