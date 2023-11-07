package com.fer.digitalno.obrazovanje.KidLingo.domain.statistic;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;

import java.time.LocalDateTime;

public abstract class Statistic {

    private String deviceId;
    private Category category;
    private Double percentageCorrect;
    private Double solvingSpeed;
    private Level level;
    private LocalDateTime playTimestamp;
}
