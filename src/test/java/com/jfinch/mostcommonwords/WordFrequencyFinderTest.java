package com.jfinch.mostcommonwords;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyFinderTest {

    @Test
    void it_can_get_most_common_words() {
        String text = "Hello Hello hello bob ((test)). Steve's another \"hello\". Trial-bob, test. ";
        WordFrequencyFinder wordFrequencyFinder = new WordFrequencyFinder();
        List<WordUsage> mostCommonWords = wordFrequencyFinder.getWordFrequencies(text);

        List<WordUsage> expectedResult = Arrays.asList(
                new WordUsage("hello", 4),
                new WordUsage("test", 2),
                new WordUsage("another", 1),
                new WordUsage("bob", 1),
                new WordUsage("steve's", 1),
                new WordUsage("trial-bob", 1)
        );

        assertEquals(expectedResult, mostCommonWords);
    }
}
