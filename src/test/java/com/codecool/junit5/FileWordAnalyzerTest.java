package com.codecool.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    PartReader reader;
    FileWordAnalyzer analyzer;

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("Main")
    @Test
    public @interface MainTest {
    }

    @BeforeEach
    void init() {
        reader = new PartReader();
        reader.setup("/Users/durlesteanu/Desktop/cap.txt", 1, 1000);
        analyzer = new FileWordAnalyzer(reader);
    }


    @MainTest
    @Disabled
    void getWordsOrderedAlphabetically() {
        List<String> testList = analyzer.getWordsOrderedAlphabetically();
        int lengthVar = Math.min(testList.size(), 5);

        for (int i = 1; i < lengthVar - 1; i++) {

            String prevWord = testList.get(i - 1).toLowerCase();
            String testWord = testList.get(i).toLowerCase();
            String nextWord = testList.get(i + 1).toLowerCase();
            assertAll(
                    () -> assertTrue(prevWord.charAt(0) <= testWord.charAt(0)),
                    () -> assertTrue(testWord.charAt(0) <= nextWord.charAt(0))
            );

        }
    }


    @MainTest
    @Disabled
    void getWordsContainingSubstring() {
        List<String> testList = analyzer.getWordsContainingSubstring("ee");
        assertEquals(testList.size(), 69);
    }

    @MainTest
    void getStringsWhichPalindromes() {
        List<String> testList = analyzer.getStringsWhichPalindromes();
        for(String word: testList){
            String reversedWord = new StringBuilder(word).reverse().toString();
            assertEquals(reversedWord, word);
        }
    }

    @Test
    @Tag("Secondary")
    void isNumeric() {
        double randomVar = Math.random() * 10;
        assertTrue(analyzer.isNumeric(String.valueOf(randomVar)));
    }
}