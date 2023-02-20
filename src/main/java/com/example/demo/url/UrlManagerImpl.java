package com.example.demo.url;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Component
public class UrlManagerImpl implements UrlManager {

    private final HashMap<String, String> inMemoryCache = new HashMap<>();

    @Override
    public String getUrlByKey(String key) {
        return inMemoryCache.get(key);
    }

    @Override
    public String shortenUrl(String url) {
        String shortenedUrl = UUID.nameUUIDFromBytes(url.getBytes()).toString();
        inMemoryCache.put(shortenedUrl, url);
        return shortenedUrl;
    }
}
