package com.jfinch.mostcommonwords;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class WordFrequencySummary {

    private List<WordUsage> mostCommonWords;
    private Integer wordCount;
    private Integer uniqueWordCount;
}
