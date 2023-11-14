package com.fer.digitalno.obrazovanje.KidLingo.domain.dictionary;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "italian_dictionary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItalianDictionary {

    @Id
    @GeneratedValue
    private Long id;
    private String wordEnglish;
    private String word;
    private Category category;
}
