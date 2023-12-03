package com.fer.digitalno.obrazovanje.KidLingo.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ClassicGame(@NotBlank String wordEnglish,
                          @NotBlank String word,
                          String imageUrl) {
}
