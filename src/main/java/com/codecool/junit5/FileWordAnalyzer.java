package com.codecool.junit5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    PartReader partReader;

    public FileWordAnalyzer(PartReader partReader) {
        this.partReader = partReader;
    }


    public List<String> getWordsOrderedAlphabetically() {
        String text = partReader.readLines();
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(text.split("\\W+")));
        wordList.sort(String.CASE_INSENSITIVE_ORDER);
        List<String> filteredWordList = wordList
                .stream()
                .filter(w -> !w.matches("[\n\r\t]") && !w.isBlank())
                .collect(Collectors.toList());
        return filteredWordList;
    }


    public List<String> getWordsContainingSubstring(String subString) {
        String text = partReader.readLines();
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(text.split("\\W+")));
        ArrayList<String> resultWordList = new ArrayList<>();
        for (String word : wordList) {
            if (word.contains(subString)) {
                resultWordList.add(word);
            }
        }
        return resultWordList;
    }

    public List<String> getStringsWhichPalindromes() {
        String text = partReader.readLines();
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(text.split("\\W+")));
        ArrayList<String> resultWordList = new ArrayList<>();
        for (String word : wordList) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            if (word.equals(sb.toString()) && word.length() > 1 && !isNumeric(word)) {
                if (!resultWordList.contains(word)) {
                    resultWordList.add(word);
                }
            }
        }
        return resultWordList;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
