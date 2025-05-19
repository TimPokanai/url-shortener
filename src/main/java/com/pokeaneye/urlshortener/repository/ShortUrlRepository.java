package com.pokeaneye.urlshortener.repository;

import com.pokeaneye.urlshortener.model.ShortUrl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {

    // Custom method to find a shortUrl by its shortCode
    Optional<ShortUrl> findByShortCode(String shortCode);

    // Checks if a shortCode already exists for collisions
    boolean existsByShortCode(String shortCode);

}
