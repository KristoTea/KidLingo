package com.fer.digitalno.obrazovanje.KidLingo.service;

import com.fer.digitalno.obrazovanje.KidLingo.dto.ClassicGame;
import com.fer.digitalno.obrazovanje.KidLingo.dto.ElectionGame;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DictionaryService {

    List<ClassicGame> getClassicGameSet(Language language, Category category);

    List<ElectionGame> getGameWithElectionCandidates(Language language, Category category);
}
