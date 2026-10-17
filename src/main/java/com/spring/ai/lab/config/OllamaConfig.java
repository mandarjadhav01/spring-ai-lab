package com.spring.ai.lab.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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


   private static final String STRICT_TOOL_POLICY_SYSTEM_PROMPT = """
         You are a helpful, accurate AI assistant with access to specialized domain tools.
         Follow these strict rules regarding tool usage:
         1. Call a tool ONLY when the user's prompt directly requires live or domain-specific data
            provided by that tool (such as weather forecasts, order tracking/cancellation,
            current date/time, or currency conversion).
         2. If the user's question requires multiple pieces of information (for example, tracking an
            order AND checking the weather in its destination city), call all relevant tools.
         3. If the user's prompt is a general knowledge question, greeting, coding question, or creative
            request that does NOT require any tool, answer directly from your own knowledge and DO NOT
            invoke any tool.
         """;

   @Bean
   public ChatClient ollamaChatClient(ChatModel ollamaChatModel) {
      return ChatClient.builder(ollamaChatModel).defaultSystem(STRICT_TOOL_POLICY_SYSTEM_PROMPT)
            .defaultTools(weatherTools, dateTimeTools)
            .build();
   }

}
