package com.pokeaneye.urlshortener.service;

import com.pokeaneye.urlshortener.repository.ShortUrlRepository;
import com.pokeaneye.urlshortener.model.ShortUrl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class UrlService {
    private final ShortUrlRepository shortUrlRepository;

    public UrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public ShortUrl createShortUrl(String originalUrl, String shortCode) {
        ShortUrl shortUrl = ShortUrl.builder()
                            .originalUrl(originalUrl)
                            .shortCode(shortCode)
                            .createdAt(LocalDateTime.now())
                            .build();
        
        return shortUrlRepository.save(shortUrl);
    }

    public ShortUrl getByShortCode(String shortCode) {
        return shortUrlRepository.findByShortCode(shortCode)
            .orElseThrow(() -> new RuntimeException("Short code not found"));
    }
}
