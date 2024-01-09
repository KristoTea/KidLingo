package com.fer.digitalno.obrazovanje.KidLingo.service;

import com.fer.digitalno.obrazovanje.KidLingo.dto.GameStatistic;
import com.fer.digitalno.obrazovanje.KidLingo.dto.StatisticByDevice;
import org.springframework.stereotype.Service;

@Service
public interface StatisticService {

    void saveGameStatistic(GameStatistic gameStatistic);
    StatisticByDevice getStatisticByDevice(String deviceId);
}
