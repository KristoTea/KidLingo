package com.fer.digitalno.obrazovanje.KidLingo.service.impl;

import com.fer.digitalno.obrazovanje.KidLingo.dao.DictionaryRepository;
import com.fer.digitalno.obrazovanje.KidLingo.dao.GeneratedPictureRepository;
import com.fer.digitalno.obrazovanje.KidLingo.domain.Dictionary;
import com.fer.digitalno.obrazovanje.KidLingo.domain.GeneratedPicture;
import com.fer.digitalno.obrazovanje.KidLingo.dto.ClassicGame;
import com.fer.digitalno.obrazovanje.KidLingo.dto.ElectionGame;
import com.fer.digitalno.obrazovanje.KidLingo.service.DictionaryService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    private final GeneratedPictureRepository generatedPictureRepository;

    @Override
    public List<ClassicGame> getClassicGameSet(Language language, Category category) {
        List<ClassicGame> classicGames = new ArrayList<>();

        for(Dictionary dictionaryRow : getGameSet(language, category)) {
            classicGames.add(createClassicGame(dictionaryRow, language));
        }

        return classicGames;
    }

    @Override
    public List<ElectionGame> getGameWithElectionCandidates(Language language, Category category) {
        List<ElectionGame> electionGames = new ArrayList<>();

        for(Dictionary dictionaryRow : getGameSet(language, category)) {
            electionGames.add(createElectionGame(dictionaryRow, language, category));
        }

        return electionGames;
    }

    private ElectionGame createElectionGame(Dictionary row, Language language, Category category) {
        String wordEnglish = row.getWord(Language.ENGLISH);
        String wordInRequestedLanguage = row.getWord(language);
        GeneratedPicture generatedPicture = generatedPictureRepository.findByWord(wordEnglish);
        String imageUrl = generatedPicture != null ? generatedPicture.getImageUrl(): null;
        List<String> wrongWords = getWrongWords(language, category, wordEnglish);

        return ElectionGame.builder()
                .wordEnglish(wordEnglish)
                .word(wordInRequestedLanguage)
                .pictureUrl(imageUrl)
                .wrongWords(wrongWords)
                .build();
    }

    private ClassicGame createClassicGame(Dictionary row, Language language) {
        String wordEnglish = row.getWord(Language.ENGLISH);
        String wordInRequestedLanguage = row.getWord(language);
        GeneratedPicture generatedPicture = generatedPictureRepository.findByWord(wordEnglish);
        String imageUrl = generatedPicture != null ? generatedPicture.getImageUrl(): null;

        return ClassicGame.builder()
                .wordEnglish(wordEnglish)
                .word(wordInRequestedLanguage)
                .imageUrl(imageUrl)
                .build();
    }

    private List<Dictionary> getGameSet(Language language, Category category) {
        List<Dictionary> dictionaryList = dictionaryRepository.findByCategory(category.name().toLowerCase());
        return getNRandomValues(dictionaryList, 5);
    }

    private List<String> getWrongWords(Language language, Category category, String word) {
        List<String> wordsInRequestedLanguage = dictionaryRepository.findByCategoryAndEnglishWordNot(category.name().toLowerCase(), word)
                .stream()
                .map(dictionary -> dictionary.getWord(language))
                .toList();
        return getNRandomValues(wordsInRequestedLanguage, 3);
    }

    private <T> List<T> getNRandomValues(List<T> values, int numOfRandomValues) {
        // TODO make sure to not choose same values multiple times
        Random random = new Random();
        List<T> randomValues = new ArrayList<>();

        for (int i = 0; i < numOfRandomValues; i++) {
            int randomIndex = random.nextInt(values.size());
            T randomValue = values.get(randomIndex);
            randomValues.add(randomValue);
        }

        return randomValues;
    }
}
