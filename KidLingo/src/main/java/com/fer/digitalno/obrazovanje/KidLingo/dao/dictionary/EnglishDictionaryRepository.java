package com.fer.digitalno.obrazovanje.KidLingo.dao.dictionary;

import com.fer.digitalno.obrazovanje.KidLingo.domain.dictionary.EnglishDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnglishDictionaryRepository extends JpaRepository<EnglishDictionary, Long> {
}
