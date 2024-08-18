package org.example.forecast.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ForecastDto {
    private String airTemperature;
    private String windSpeed;
}
