package com.fer.digitalno.obrazovanje.KidLingo.rest;

import com.fer.digitalno.obrazovanje.KidLingo.dto.GameStatistic;
import com.fer.digitalno.obrazovanje.KidLingo.dto.StatisticByDevice;
import com.fer.digitalno.obrazovanje.KidLingo.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping
    public ResponseEntity<?> saveGameStatistic(@RequestBody GameStatistic gameStatistic) {
        try {
            statisticService.saveGameStatistic(gameStatistic);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<?> getStatisticForDevice(@PathVariable String deviceId) {
        try {
            StatisticByDevice statisticByDevice = statisticService.getStatisticByDevice(deviceId);
            return ResponseEntity.status(HttpStatus.OK).body(statisticByDevice);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}
