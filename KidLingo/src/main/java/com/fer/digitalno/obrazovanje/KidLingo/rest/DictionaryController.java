package com.fer.digitalno.obrazovanje.KidLingo.rest;

import com.fer.digitalno.obrazovanje.KidLingo.dto.ClassicGame;
import com.fer.digitalno.obrazovanje.KidLingo.dto.ElectionGame;
import com.fer.digitalno.obrazovanje.KidLingo.service.DictionaryService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping("/election/{language}/{category}")
    public ResponseEntity<?> getGameWithElectionCandidates(@PathVariable Language language, @PathVariable Category category) {
        List<ElectionGame> gameSet = dictionaryService.getGameWithElectionCandidates(language, category);
        return ResponseEntity.status(HttpStatus.OK).body(gameSet);
    }

    @GetMapping("/{language}/{category}")
    public ResponseEntity<?> getClassicGame(@PathVariable Language language, @PathVariable Category category) {
        List<ClassicGame> gameSet = dictionaryService.getClassicGameSet(language, category);
        return ResponseEntity.status(HttpStatus.OK).body(gameSet);
    }
}
