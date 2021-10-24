package com.jfinch.mostcommonwords.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class WordFrequencySummariserTest {

    WordFrequencySummariser wordFrequencySummariser;

    @BeforeEach
    void setUp() {
        this.wordFrequencySummariser = new WordFrequencySummariser(new WordFrequencyFinder());
    }

    @Test
    void it_can_summarise() {
        String text = "Hello Hello hello bob ((test)). Steve's another \"hello\". Trial-bob, test. ";

        WordFrequencySummary wordFrequencySummary = this.wordFrequencySummariser.getWordFrequencySummary(text, 5);

        List<WordUsage> expectedWordsListResult = Arrays.asList(
                new WordUsage("hello", 4),
                new WordUsage("test", 2),
                new WordUsage("another", 1),
                new WordUsage("bob", 1),
                new WordUsage("steve's", 1)
//                new WordUsage("trial-bob", 1) // Missing via limit
        );

        WordFrequencySummary expectedWordFrequencySummary = new WordFrequencySummary(
                expectedWordsListResult,
                10,
                6
        );

        assertEquals(expectedWordFrequencySummary, wordFrequencySummary);

    }

    @Test
    void it_can_do_a_full_book() throws IOException {
//        String text = Files.readString(Path.of("/Users/jfinch/Downloads/frankenstein.txt"), StandardCharsets.UTF_8);
        String text = Files.readString(Path.of("/Users/jfinch/Downloads/pg1184.txt"), StandardCharsets.UTF_8);
        WordFrequencySummary wordFrequencySummary = this.wordFrequencySummariser.getWordFrequencySummary(text, 5);

        System.out.println(wordFrequencySummary);

    }
}
