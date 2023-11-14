package com.fer.digitalno.obrazovanje.KidLingo.dao;

import com.fer.digitalno.obrazovanje.KidLingo.domain.GeneratedPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneratedPictureRepository extends JpaRepository<GeneratedPicture, Long> {

    Optional<GeneratedPicture> findByWord(String word);
}
