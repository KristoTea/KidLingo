package com.fer.digitalno.obrazovanje.KidLingo.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

import java.util.List;

@Builder
public record ElectionGame(@NotBlank String wordEnglish,
                           @NotBlank String word,
                           @NotEmpty List<String> wrongWords,
                           String pictureUrl) {
}
