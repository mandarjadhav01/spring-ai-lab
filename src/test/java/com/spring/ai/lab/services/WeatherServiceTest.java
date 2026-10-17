package com.spring.ai.lab.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.spring.ai.lab.tools.services.WeatherService;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

class WeatherServiceTest {

    @Test
    void testGetWeatherByCity() {
                RestTemplate restTemplate = new RestTemplate();
                MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
                WeatherService weatherService = new WeatherService(restTemplate);
                ReflectionTestUtils.setField(weatherService, "apiKey", "test-api-key");
                ReflectionTestUtils.setField(weatherService, "url", "https://api.openweathermap.org/data/2.5/weather");

                mockServer.expect(requestTo("https://api.openweathermap.org/data/2.5/weather?q=London&appid=test-api-key&units=metric"))
                                .andRespond(withSuccess("""
                                                {
                                                    "weather": [{ "description": "clear sky" }],
                                                    "main": { "temp": 18.5, "feels_like": 17.2, "humidity": 60 }
                                                }
                                                """, MediaType.APPLICATION_JSON));

        String result = weatherService.getWeatherByCity("London");

                assertEquals("Current weather in London: clear sky, temperature: 18.5\u00B0C (feels like 17.2\u00B0C), humidity: 60%.", result);
                mockServer.verify();
    }
}
