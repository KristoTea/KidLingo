package com.fer.digitalno.obrazovanje.KidLingo.service.impl;

import com.fer.digitalno.obrazovanje.KidLingo.dao.statistic.EnglishStatisticRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.statistic.FrenchStatisticRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.statistic.GermanStatisticRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.statistic.ItalianStatisticRepository;
import com.fer.digitalno.obrazovanje.KidLingo.domain.statistic.*;
import com.fer.digitalno.obrazovanje.KidLingo.dto.GameStatistic;
import com.fer.digitalno.obrazovanje.KidLingo.service.StatisticService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private EnglishStatisticRepository englishStatisticRepository;
    private FrenchStatisticRepository frenchStatisticRepository;
    private GermanStatisticRepository germanStatisticRepository;
    private ItalianStatisticRepository italianStatisticRepository;

    @Override
    public void saveGameData(Language language, GameStatistic gameStatistic) {
        Statistic statistic = mapToStatistic(gameStatistic);
        switch (language) {
            case ENGLISH -> englishStatisticRepository.save(new EnglishStatistic(statistic));
            case FRENCH -> frenchStatisticRepository.save(new FrenchStatistic(statistic));
            case GERMAN -> germanStatisticRepository.save(new GermanStatistic(statistic));
            case ITALIAN -> italianStatisticRepository.save(new ItalianStatistic(statistic));
            default -> throw new IllegalArgumentException("Unknown language");
        }
    }

    private static Statistic mapToStatistic(GameStatistic gameStatistic) {
        return new Statistic(gameStatistic.deviceId(),
                             gameStatistic.category(),
                             gameStatistic.percentageCorrect(),
                             gameStatistic.solvingSpeed(),
                             gameStatistic.level(),
                             LocalDateTime.now());
    }
}
