package com.fer.digitalno.obrazovanje.KidLingo.dao;

import com.fer.digitalno.obrazovanje.KidLingo.domain.GeneratedPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneratedPictureRepository extends JpaRepository<GeneratedPicture, Long> {

    @Query(value = "SELECT * FROM generated_picture WHERE word = ?1", nativeQuery = true)
    GeneratedPicture findByWord(String word);
}
