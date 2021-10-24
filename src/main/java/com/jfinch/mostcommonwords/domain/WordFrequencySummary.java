package com.jfinch.mostcommonwords.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WordFrequencySummary {

    private List<WordUsage> mostCommonWords;
    private Integer wordCount;
    private Integer uniqueWordCount;
}
