package com.spring.ai.lab.config;

import com.spring.ai.lab.migration.tools.MigrationTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.spring.ai.lab.tools.DateTimeTools;
import com.spring.ai.lab.tools.WeatherTools;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OllamaConfig {

    private final WeatherTools weatherTools;
    private final DateTimeTools dateTimeTools;
    private final MigrationTools migrationTools;


    @Value("classpath:/prompts/STRICT_TOOL_POLICY_SYSTEM_PROMPT.st")
    private Resource strictToolPolicySystemPrompt;

    @Value("classpath:/prompts/ARCHITECT_AGENT_SYSTEM_PROMPT.st")
    private Resource architectAgentSystemPrompt;

    @Value("classpath:/prompts/CODE_AGENT_SYSTEM_PROMPT.st")
    private Resource codeAgentSystemPrompt;

    @Value("classpath:/prompts/VALIDATOR_AGENT_SYSTEM_PROMPT.st")
    private Resource validatorAgentSystemPrompt;


    @Bean
    public ChatClient ollamaChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).defaultSystem(strictToolPolicySystemPrompt)
                .defaultTools(weatherTools, dateTimeTools)
                .build();
    }

    @Bean
    public ChatClient architectAgentChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).defaultSystem(architectAgentSystemPrompt)
                .defaultTools(migrationTools)
                .build();
    }

    @Bean
    public ChatClient codeAgentChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).defaultSystem(codeAgentSystemPrompt)
                .defaultTools(migrationTools)
                .build();
    }

    @Bean
    public ChatClient validatorAgentChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel).defaultSystem(validatorAgentSystemPrompt)
                .defaultTools(migrationTools)
                .build();
    }

    @Bean
    public ChatClient databaseChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel)
                .build();
    }

    @Bean
    public ChatClient ragChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel)
                .build();
    }


}
