package com.spring.ai.lab.tools.services;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final RestTemplate restTemplate;

    @Value("${openweathermap.api-key}")
    private String apiKey;

    @Value("${openweathermap.url}")
    private String url;

    public String getWeatherByCity(String city) {
        try {
            String formattedUrl = UriComponentsBuilder.fromUriString(url)
                    .queryParam("q", city)
                    .queryParam("appid", apiKey)
                    .queryParam("units", "metric")
                    .build()
                    .toUriString();

            ResponseEntity<String> response = restTemplate.getForEntity(formattedUrl, String.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                JsonNode data = OBJECT_MAPPER.readTree(response.getBody());

                String description = data.path("weather").path(0).path("description").asText();
                String temp = data.path("main").path("temp").asText();
                String feelsLike = data.path("main").path("feels_like").asText();
                String humidity = data.path("main").path("humidity").asText();

                log.info("Successfully fetched weather for '{}': {}, {}°C", city, description, temp);

                return String.format(
                        "Current weather in %s: %s, temperature: %s°C (feels like %s°C), humidity: %s%%.",
                        city,
                        description,
                        temp,
                        feelsLike,
                        humidity);
            } else {
                log.error("Failed to fetch weather for city {}: HTTP {}", city, response.getStatusCode());
                return "Unable to fetch weather for city " + city;
            }
        } catch (Exception e) {
            log.error("Error fetching weather for city {}: {}", city, e.getMessage());
            return "Unable to fetch weather for city " + city;
        }
    }
}
