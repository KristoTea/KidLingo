package com.fer.digitalno.obrazovanje.KidLingo.domain;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Language;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@Table(name = "english_dictionary")
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "english")
    private String englishWord;

    @Column(name = "french")
    private String frenchWord;

    @Column(name = "italian")
    private String italianWord;

    @Column(name = "german")
    private String germanWord;

    private String category;

    public String getWord(Language language) {
        return switch (language) {
            case FRENCH -> frenchWord;
            case ITALIAN -> italianWord;
            case GERMAN -> germanWord;
            default -> englishWord;
        };
    }
}
