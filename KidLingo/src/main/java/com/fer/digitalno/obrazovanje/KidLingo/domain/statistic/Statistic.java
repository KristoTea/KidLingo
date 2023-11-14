package com.fer.digitalno.obrazovanje.KidLingo.domain.statistic;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {

    private String deviceId;
    private Category category;
    private Double percentageCorrect;
    private Double solvingSpeed;
    private Level level;
    private LocalDateTime playTimestamp;
}
