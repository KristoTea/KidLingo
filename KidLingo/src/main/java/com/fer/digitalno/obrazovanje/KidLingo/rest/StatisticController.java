package com.fer.digitalno.obrazovanje.KidLingo.rest;

import com.fer.digitalno.obrazovanje.KidLingo.dto.GameStatistic;
import com.fer.digitalno.obrazovanje.KidLingo.service.StatisticService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping("/{language}")
    public ResponseEntity<?> saveGameData(@PathVariable Language language, @RequestBody GameStatistic gameStatistic) {
        try {
            statisticService.saveGameData(language, gameStatistic);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }
}
