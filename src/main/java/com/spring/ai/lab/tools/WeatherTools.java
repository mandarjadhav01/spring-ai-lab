package com.spring.ai.lab.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import com.spring.ai.lab.tools.services.WeatherService;

import lombok.RequiredArgsConstructor;

@Component 
@RequiredArgsConstructor 
public class WeatherTools {

    private final WeatherService weatherService;

    @Tool(description = """
            Get the current weather for a city using OpenWeatherMap API.
            This tool should get called only if user asks about weather conditions.
            Do not use this tool if question is not related to weather conditions.
            """)
    public String getWeatherByCity(@ToolParam(description = "City name") String city) {
        return weatherService.getWeatherByCity(city);
    }

}
