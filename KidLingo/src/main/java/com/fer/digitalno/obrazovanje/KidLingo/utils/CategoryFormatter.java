package com.fer.digitalno.obrazovanje.KidLingo.utils;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        try {
            return Category.valueOf(text.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw new ParseException("Invalid category: " + text, 0);
        }
    }

    @Override
    public String print(Category object, Locale locale) {
        return object.name().toLowerCase();
    }
}
