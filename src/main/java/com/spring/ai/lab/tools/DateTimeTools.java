package com.spring.ai.lab.tools;

import java.time.LocalDateTime;

import org.springframework.ai.tool.annotation.Tool;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DateTimeTools {

    @Tool(description = """
            Get the current date and time in the user's timezone.
            This tool should get called only if user asks about weather conditions.
            Do not use this tool if question is not related to weather conditions.""")
    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

}
