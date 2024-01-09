package com.fer.digitalno.obrazovanje.KidLingo.dto;

import com.fer.digitalno.obrazovanje.KidLingo.dto.statistic.StatisticByLanguage;

public record StatisticByDevice(StatisticByLanguage englishStatistic,
                                StatisticByLanguage frenchStatistic,
                                StatisticByLanguage germanStatistic,
                                StatisticByLanguage italianStatistic) {

}