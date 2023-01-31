package com.example.weatherapi.service;

import com.example.weatherapi.model.WeatherForecast;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;;

@Service
public class WeatherApiService {

    private static final String API_KEY = "";
    private static final String API_URL = "https://api.weatherapi.com/v1/forecast.json?key="+API_KEY+"&q={city}&days=14";

    //get the 14-day forecast
    public WeatherForecast get14DayForecast(String city) throws JsonProcessingException {
        String jsonResponse = callWeatherAPI(city);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonResponse, WeatherForecast.class);
    }
    //create bean for RestTemplate
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //configuration for bean life cycle
    @Lazy
    @Autowired
    private RestTemplate restTemplate;


    //makes the API call and return the JSON response
    private String callWeatherAPI(String city) {

        if(city.isEmpty()){
            return "City and country must be provided";
        }
        try {
            String response = restTemplate.getForObject(API_URL, String.class, city);
            return response;

        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return "City not found";
            } else {
                return "An error occurred: " + ex.getMessage();
            }
        }
    }
}
