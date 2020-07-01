package com.codecool.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Tag("Main")
    @Test
    public @interface MainTest{}

    @MainTest
    void getWordsOrderedAlphabetically() {
    }

    @MainTest
    void getWordsContainingSubstring() {
    }

    @MainTest
    void getStringsWhichPalindromes() {
    }

    @Test
    @Tag("Secondary")
    void isNumeric() {
    }
}