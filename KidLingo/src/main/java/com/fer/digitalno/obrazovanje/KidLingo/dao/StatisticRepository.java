package com.fer.digitalno.obrazovanje.KidLingo.dao;

import com.fer.digitalno.obrazovanje.KidLingo.domain.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    @Query(value = "SELECT number_of_correct_answers FROM statistic WHERE language = ?1 AND level = ?2 AND category = ?3 ORDER BY play_timestamp DESC LIMIT 20", nativeQuery = true)
    List<Integer> findAllNumberOfCorrectAnswersByLanguageAndLevelAndCategory(String language, String level, String category);

    @Query(value = "SELECT solving_speed FROM statistic WHERE language = ?1 AND level = ?2 AND category = ?3 ORDER BY play_timestamp DESC LIMIT 20", nativeQuery = true)
    List<Double> findAllSolvingSpeedByLanguageAndLevelAndCategory(String language, String level, String category);

    List<Statistic> findAllByLanguageOrderByPlayTimestamp(String language);
}
