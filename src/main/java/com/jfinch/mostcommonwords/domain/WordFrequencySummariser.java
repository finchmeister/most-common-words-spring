package com.jfinch.mostcommonwords.domain;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordFrequencySummariser {

    private WordFrequencyFinder wordFrequencyFinder;

    WordFrequencySummariser(
            WordFrequencyFinder wordFrequencyFinder
    ) {
        this.wordFrequencyFinder = wordFrequencyFinder;
    }

    public WordFrequencySummary getWordFrequencySummary(String text, Integer mostCommonWordLimit) {
        List<WordUsage> wordFrequencies = wordFrequencyFinder.getWordFrequencies(text);

        List<WordUsage> mostCommonWords = wordFrequencies.stream().limit(mostCommonWordLimit).collect(Collectors.toList());

        return new WordFrequencySummary(
                mostCommonWords,
                getCountWords(wordFrequencies),
                getCountUniqueWords(wordFrequencies)
        );
    }

    private Integer getCountWords(List<WordUsage> wordFrequencies) {
        return wordFrequencies.stream().mapToInt(WordUsage::getUsages).sum();
    }

    private Integer getCountUniqueWords(List<WordUsage> wordFrequencies) {
        return wordFrequencies.size();
    }
}
