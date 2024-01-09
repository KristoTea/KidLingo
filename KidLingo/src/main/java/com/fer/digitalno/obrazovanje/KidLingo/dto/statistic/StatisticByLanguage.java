package com.fer.digitalno.obrazovanje.KidLingo.dto.statistic;

import java.util.List;

public record StatisticByLanguage(CorrectAnswers averageCorrectAnswers,
                                  SolvingSpeed averageSolvingSpeed,
                                  List<ProgressStatistic> progressStatistic) {
}
