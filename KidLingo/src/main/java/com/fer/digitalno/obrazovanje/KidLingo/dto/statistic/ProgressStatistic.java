package com.fer.digitalno.obrazovanje.KidLingo.dto.statistic;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;

import java.time.LocalDateTime;

public record ProgressStatistic(LocalDateTime playTimestamp,
                                Integer numberOfCorrectAnswers,
                                Level level,
                                Category category) {
}