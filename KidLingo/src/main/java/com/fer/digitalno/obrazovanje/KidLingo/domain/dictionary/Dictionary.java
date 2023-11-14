package com.fer.digitalno.obrazovanje.KidLingo.domain.dictionary;

import com.fer.digitalno.obrazovanje.KidLingo.utils.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dictionary {

    private String wordEnglish;
    private String word;
    private Category category;
}
