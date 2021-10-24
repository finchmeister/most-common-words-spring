package com.jfinch.mostcommonwords.controller;

import com.jfinch.mostcommonwords.domain.UrlTextDownloader;
import com.jfinch.mostcommonwords.domain.WordFrequencySummariser;
import com.jfinch.mostcommonwords.domain.WordFrequencySummary;
import com.jfinch.mostcommonwords.dto.TextRequestDto;
import com.jfinch.mostcommonwords.dto.UrlRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
public class MostCommonWordsController {

    WordFrequencySummariser wordFrequencySummariser;
    private UrlTextDownloader urlTextDownloader;
    private Integer mostCommonWordLimit;

    @Autowired
    public MostCommonWordsController(
            WordFrequencySummariser wordFrequencySummariser,
            UrlTextDownloader urlTextDownloader,
            @Value("${mostCommonWordLimit}") Integer mostCommonWordLimit
    ) {
        this.wordFrequencySummariser = wordFrequencySummariser;
        this.urlTextDownloader = urlTextDownloader;
        this.mostCommonWordLimit = mostCommonWordLimit;
    }

    @PostMapping("/text")
    WordFrequencySummary getForText(@RequestBody TextRequestDto textRequestDto) {
        return this.wordFrequencySummariser.getWordFrequencySummary(textRequestDto.text, this.mostCommonWordLimit);
    }

    @PostMapping("/url")
    WordFrequencySummary getForUrl(@RequestBody UrlRequestDto urlRequestDto) throws IOException {
        String text = urlTextDownloader.getTextFromUrl(urlRequestDto.url);
        return this.wordFrequencySummariser.getWordFrequencySummary(text, this.mostCommonWordLimit);
    }

}
