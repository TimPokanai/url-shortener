package com.pokeaneye.urlshortener.service;

import com.pokeaneye.urlshortener.repository.ShortUrlRepository;
import com.pokeaneye.urlshortener.model.ShortUrl;

import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public ShortUrl getByShortCode(String shortCode) {
        return shortUrlRepository.findByShortCode(shortCode)
            .orElseThrow(() -> new RuntimeException("Short code not found"));
    }
}
