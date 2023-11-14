package com.fer.digitalno.obrazovanje.KidLingo.dto;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GameStatistic(@NotBlank String deviceId,
                            @NotNull Category category,
                            @NotNull Double percentageCorrect,
                            @NotNull Double solvingSpeed,
                            @NotNull Level level) {
}
