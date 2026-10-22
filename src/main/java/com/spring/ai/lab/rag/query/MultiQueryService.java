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
public class MultiQueryService {

    private final ChatClient chatClient;

    public List<String> generateQueries(String query) {
        String prompt = """
                Generate 4 concise search queries related to the following user query.
                
                The generated queries should:
                - improve enterprise document retrieval
                - user alternative terminology
                - expand the search perspective
                - remain concise and searchable
                
                Return only the queries, one query per line.
                
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
