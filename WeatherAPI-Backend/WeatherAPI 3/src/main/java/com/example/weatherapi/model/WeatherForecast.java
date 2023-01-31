package com.example.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//Creating a model to bring the incoming json response to the desired form.
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherForecast {

    @JsonProperty("forecast")
    private Forecast forecast;



}
