package com.fer.digitalno.obrazovanje.KidLingo.dao;

import com.fer.digitalno.obrazovanje.KidLingo.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

    @Query(value = "SELECT * FROM dictionary WHERE category = ?1 AND english != ?2", nativeQuery = true)
    List<Dictionary> findByCategoryAndEnglishWordNot(String category, String englishWord);

    @Query(value = "SELECT * FROM dictionary WHERE category = ?1 ORDER BY id", nativeQuery = true)
    List<Dictionary> findByCategory(String category);
}
