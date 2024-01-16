package com.fer.digitalno.obrazovanje.KidLingo.service.impl;

import com.fer.digitalno.obrazovanje.KidLingo.dao.StatisticRepository;
import com.fer.digitalno.obrazovanje.KidLingo.domain.Statistic;
import com.fer.digitalno.obrazovanje.KidLingo.dto.GameStatistic;
import com.fer.digitalno.obrazovanje.KidLingo.dto.StatisticByDevice;
import com.fer.digitalno.obrazovanje.KidLingo.dto.statistic.*;
import com.fer.digitalno.obrazovanje.KidLingo.service.StatisticService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Level;
import com.fer.digitalno.obrazovanje.KidLingo.utils.StatisticType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    @Override
    public void saveGameStatistic(GameStatistic gameStatistic) {
        statisticRepository.save(mapToStatistic(gameStatistic));
    }

    @Override
    public StatisticByDevice getStatisticByDevice(String deviceId) {
        StatisticByLanguage englishStatistic = getStatisticByLanguage(Language.ENGLISH);
        StatisticByLanguage frenchStatistic = getStatisticByLanguage(Language.FRENCH);
        StatisticByLanguage germanStatistic = getStatisticByLanguage(Language.GERMAN);
        StatisticByLanguage italianStatistic = getStatisticByLanguage(Language.ITALIAN);

        return new StatisticByDevice(englishStatistic, frenchStatistic,
                germanStatistic, italianStatistic);
    }

    private StatisticByLanguage getStatisticByLanguage(Language language) {
        CorrectAnswers averageCorrectAnswers = getAverageCorrectAnswers(language);
        SolvingSpeed averageSolvingSpeed = getAverageSolvingSpeed(language);
        List<ProgressStatistic> progressStatistic = getProgressStatistic(language);

        return new StatisticByLanguage(averageCorrectAnswers,
                                        averageSolvingSpeed,
                                        progressStatistic);
    }

    private CorrectAnswers getAverageCorrectAnswers(Language language) {
        AverageScoreByLevel elected = getAverageScoreByLevel(language, Level.ELECTED, StatisticType.CORRECT_ANSWERS);
        AverageScoreByLevel typed = getAverageScoreByLevel(language, Level.TYPED, StatisticType.CORRECT_ANSWERS);

        return new CorrectAnswers(elected, typed);
    }

    private SolvingSpeed getAverageSolvingSpeed(Language language) {
        AverageScoreByLevel elected = getAverageScoreByLevel(language, Level.ELECTED, StatisticType.SOLVING_SPEED);
        AverageScoreByLevel typed = getAverageScoreByLevel(language, Level.TYPED, StatisticType.SOLVING_SPEED);

        return new SolvingSpeed(elected, typed);
    }

    private AverageScoreByLevel getAverageScoreByLevel(Language language,
                                                       Level level,
                                                       StatisticType statisticType) {

        Double colors = getAverageScoreByLanguageAndLevelAndCategory(language,level, Category.COLORS, statisticType);
        Double animals = getAverageScoreByLanguageAndLevelAndCategory(language,level, Category.ANIMALS, statisticType);
        Double food = getAverageScoreByLanguageAndLevelAndCategory(language,level, Category.FOOD, statisticType);
        Double objects = getAverageScoreByLanguageAndLevelAndCategory(language,level, Category.OBJECTS, statisticType);

        return new AverageScoreByLevel(colors, animals, food, objects);
    }

    private Double getAverageScoreByLanguageAndLevelAndCategory(Language language,
                                                                Level level,
                                                                Category category,
                                                                StatisticType statisticType) {
        Double averageScore = 0.0;
        if(statisticType.equals(StatisticType.CORRECT_ANSWERS)) {
            List<Integer> scores = statisticRepository
                    .findAllNumberOfCorrectAnswersByLanguageAndLevelAndCategory(language.name(), level.name(), category.name());
            if(!scores.isEmpty()) {
                averageScore = (double) (scores.stream().reduce(0, Integer::sum)) / scores.size();
            }
        }

        if(statisticType.equals(StatisticType.SOLVING_SPEED)) {
            List<Double> scores = statisticRepository
                    .findAllSolvingSpeedByLanguageAndLevelAndCategory(language.name(), level.name(), category.name());
            if(!scores.isEmpty()) {
                averageScore = scores.stream().reduce(0.0, Double::sum) / scores.size();
            }
        }

        return averageScore;
    }

    private List<ProgressStatistic> getProgressStatistic(Language language) {
        List<Statistic> statistics = statisticRepository.findAllByLanguageOrderByPlayTimestamp(language.name());
        return statistics
                .stream()
                .map(statistic -> new ProgressStatistic(statistic.getPlayTimestamp(),
                                                        statistic.getNumberOfCorrectAnswers(),
                                                        Level.valueOf(statistic.getLevel()),
                                                        Category.valueOf(statistic.getCategory())))
                .toList();
    }

    private Statistic mapToStatistic(GameStatistic gameStatistic) {
        return new Statistic(gameStatistic.deviceId(),
                gameStatistic.language().name(),
                gameStatistic.level().name(),
                gameStatistic.category().name(),
                gameStatistic.numberOfCorrectAnswers(),
                gameStatistic.solvingSpeed(),
                LocalDateTime.now());
    }
}
