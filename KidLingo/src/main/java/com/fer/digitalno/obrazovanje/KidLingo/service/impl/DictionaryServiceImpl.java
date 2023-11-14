package com.fer.digitalno.obrazovanje.KidLingo.service.impl;

import com.fer.digitalno.obrazovanje.KidLingo.dao.dictionary.EnglishDictionaryRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.dictionary.FrenchDictionaryRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.dictionary.GermanDictionaryRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.dictionary.ItalianDictionaryRepository;
import com.fer.digitalno.obrazovanje.KidLingo.domain.dictionary.Dictionary;
import com.fer.digitalno.obrazovanje.KidLingo.dto.ClassicGame;
import com.fer.digitalno.obrazovanje.KidLingo.dto.ElectionGame;
import com.fer.digitalno.obrazovanje.KidLingo.service.DictionaryService;
import com.fer.digitalno.obrazovanje.KidLingo.service.GeneratedPictureService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private EnglishDictionaryRepository englishDictionaryRepository;
    private FrenchDictionaryRepository frenchDictionaryRepository;
    private GermanDictionaryRepository germanDictionaryRepository;
    private ItalianDictionaryRepository italianDictionaryRepository;

    private GeneratedPictureService generatedPictureService;

    @Override
    public List<ClassicGame> getClassicGameSet(Language language, Category category) {
        // get game set
        // map picture if is present in db
        return null;
    }

    @Override
    public List<ElectionGame> getGameWithElectionCandidates(Language language, Category category) {
        // get game set
        // map picture if is present in db
        // add wrong words
        return null;
    }

    private List<Dictionary> getGameSet(Language language, Category category) {
        switch (language) {
            case ENGLISH:
                break;
            case FRENCH:
                break;
            case GERMAN:
                break;
            case ITALIAN:
                break;
            default:
                throw new IllegalArgumentException("Unknown language!");
        }
        return null;
    }

    private List<String> getWrongWords(Language language, Category category, String word) {
        switch (language) {
            case ENGLISH:
                break;
            case FRENCH:
                break;
            case GERMAN:
                break;
            case ITALIAN:
                break;
            default:
                throw new IllegalArgumentException("Unknown language!");
        }
        return null;
    }
}
