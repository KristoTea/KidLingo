package com.fer.digitalno.obrazovanje.KidLingo.domain.dictionary;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "french_dictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FrenchDictionary extends Dictionary {

    @Id
    @GeneratedValue
    private Long id;
    private String wordEnglish;
    private String word;
    private Category category;
    private Long noGuess;
    private Long noPicked;
}
