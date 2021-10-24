package com.jfinch.mostcommonwords.domain;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

@Service
public class UrlTextDownloader {

    public String getTextFromUrl(String url) throws IOException {
        return IOUtils.toString(new URL(url), Charset.defaultCharset());
    }
}
