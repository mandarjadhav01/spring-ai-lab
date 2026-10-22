package com.spring.ai.lab.rag.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HyDEService {

    private final ChatClient chatClient;

    public String generateHypotheticalDocument(String query) {
        String prompt = """
                Generate a concise hypothetical enterprise retrieval document for the following query
                (in less than 60 words).
                
                The generated text should:
                - improve semantic retrieval quality
                - contain operational terminology
                - contain enterprise technical vocabulary
                - remain under 60 words.
                
                Do not generate explanations, resolutions, instructions, headings, or bullet points.
                
                Query:
                %s
                """.formatted(query);

        return chatClient.prompt().user(prompt).call().content();
    }
}
