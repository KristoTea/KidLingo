package com.fer.digitalno.obrazovanje.KidLingo.domain.statistic;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "english_statistic")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EnglishStatistic extends Statistic {

    @Id
    @GeneratedValue
    private Long id;
    private String deviceId;
    private Category category;
    private Double percentageCorrect;
    private Double solvingSpeed;
    private Level level;
    private LocalDateTime playTimestamp;
}
