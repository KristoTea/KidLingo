package com.fer.digitalno.obrazovanje.KidLingo.dto;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GameStatistic(@NotBlank String deviceId,
                            @NotBlank Language language,
                            @NotNull Level level,
                            @NotNull Category category,
                            @NotNull Integer numberOfCorrectAnswers,
                            @NotNull Double solvingSpeed) {
}
