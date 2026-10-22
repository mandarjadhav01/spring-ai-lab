package com.spring.ai.lab.rag.query;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryRewritingService {

    private final ChatClient chatClient;

    public String rewrite(String query) {
        String prompt = """
                Rewrite the following enterprise search query to improve retrieval quality
                for technical support and operational troubleshooting.
                
                Keep the rewritten query concise.
                
                Query:
                %s
                
                """.formatted(query);

        return chatClient.prompt().user(prompt).call().content();

    }

}
