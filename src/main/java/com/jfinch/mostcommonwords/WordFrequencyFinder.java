package com.jfinch.mostcommonwords;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyFinder {

    public List<WordUsage> getWordFrequencies(String text) {
        StringTokenizer st = new StringTokenizer(text);

        Map<String, Integer> wordFrequency = new HashMap<>();

        while (st.hasMoreTokens()) {
            String word = filterWord(st.nextToken());
            word = normaliseWord(word);
            wordFrequency.merge(word, 1, Integer::sum);
        }

        return wordFrequency
                .entrySet()
                .stream()
                .map(e -> new WordUsage(e.getKey(), e.getValue())).
                sorted(Comparator.comparingInt(WordUsage::getUsages).reversed().thenComparing(WordUsage::getWord))
                .collect(Collectors.toList());
    }

    private String filterWord(String word) {
        return word
                .replaceAll("(^[^A-Za-z0-9]+)", "")
                .replaceAll("([^A-Za-z0-9]+)$", "");
    }

    private String normaliseWord(String word) {
        return word.toLowerCase(Locale.ROOT);
    }
}
