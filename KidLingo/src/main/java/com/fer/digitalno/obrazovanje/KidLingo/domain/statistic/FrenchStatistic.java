package com.fer.digitalno.obrazovanje.KidLingo.domain.statistic;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "french_statistic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrenchStatistic {

    @Id
    @GeneratedValue
    private Long id;
    private String deviceId;
    private Category category;
    private Double percentageCorrect;
    private Double solvingSpeed;
    private Level level;
    private LocalDateTime playTimestamp;

    public FrenchStatistic(Statistic statistic) {
        this.deviceId = statistic.getDeviceId();
        this.category = statistic.getCategory();
        this.percentageCorrect = statistic.getPercentageCorrect();
        this.solvingSpeed = statistic.getSolvingSpeed();
        this.level = statistic.getLevel();
        this.playTimestamp = statistic.getPlayTimestamp();
    }
}
