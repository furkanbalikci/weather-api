package com.example.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Day {
    @JsonProperty("maxtemp_c")
    private double maxTempCelsius;
    @JsonProperty("mintemp_c")
    private double minTempCelsius;
    @JsonProperty("avgtemp_c")
    private double avgTempCelisius;
    @JsonProperty("condition")
    private Condition condition;
}
