package com.fer.digitalno.obrazovanje.KidLingo.utils;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class LanguageFormatter implements Formatter<Language> {

    @Override
    public Language parse(String text, Locale locale) throws ParseException {
        try {
            return Language.valueOf(text.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw new ParseException("Invalid language: " + text, 0);
        }
    }

    @Override
    public String print(Language object, Locale locale) {
        return object.name().toLowerCase();
    }
}
