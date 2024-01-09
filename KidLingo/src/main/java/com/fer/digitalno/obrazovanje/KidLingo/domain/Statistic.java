package com.fer.digitalno.obrazovanje.KidLingo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@Table(name = "statistic")
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "language")
    private String language;

    @Column(name = "level")
    private String level;

    @Column(name = "category")
    private String category;

    @Column(name = "number_of_correct_answers")
    private Integer numberOfCorrectAnswers;

    @Column(name = "solving_speed")
    private Double solvingSpeed;

    @Column(name = "play_timestamp")
    private LocalDateTime playTimestamp;

    public Statistic(String deviceId, String language, String level,
                     String category, Integer numberOfCorrectAnswers,
                     Double solvingSpeed, LocalDateTime playTimestamp) {
        this.deviceId = deviceId;
        this.language = language;
        this.level = level;
        this.category = category;
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
        this.solvingSpeed = solvingSpeed;
        this.playTimestamp = playTimestamp;
    }
}
