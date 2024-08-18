package org.example.forecast.controller;

import lombok.RequiredArgsConstructor;
import org.example.forecast.dto.ForecastDto;
import org.example.forecast.service.ForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class ForecastController {

    private final ForecastService forecastService;

    @GetMapping ("/forecast")
    public ResponseEntity<ForecastDto> create(@RequestParam String lat, String lon, String start, String end) throws IOException {
        return ResponseEntity.ok(forecastService.receiveForecastForEvent(lat, lon, start, end));
    }

}
