package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherForecast;
import com.example.weatherapi.service.WeatherApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiController {

    private final WeatherApiService weatherApiService;

    public WeatherApiController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    //Route for main page. Get variable in path and call API with it.
    @GetMapping("/weather/{city}")
    public WeatherForecast get14DayForecast(@PathVariable String city) throws JsonProcessingException {
        return weatherApiService.get14DayForecast(city);
    }
}
