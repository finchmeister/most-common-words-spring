package com.jfinch.mostcommonwords.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class WordUsage {

    private final String word;
    private final Integer usages;

    public WordUsage(String word, Integer usages) {
        this.word = word;
        this.usages = usages;
    }

    public String getWord() {
        return word;
    }

    public Integer getUsages() {
        return usages;
    }
}
