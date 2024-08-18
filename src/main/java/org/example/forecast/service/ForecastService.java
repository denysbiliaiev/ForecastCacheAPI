package org.example.forecast.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.forecast.dto.ForecastDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ForecastService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper mapper;

    public ForecastDto receiveForecastForEvent(String lat, String lon, String start, String end) throws IOException {
        String key = start + ";" + lat + ";" + lon;

        ForecastDto forecast = new ForecastDto();

        if (redisTemplate.opsForValue().get(key) != null) {
            forecast = mapper.readValue(redisTemplate.opsForValue().get(key).toString(), ForecastDto.class);
        }

        return forecast;
    }
}