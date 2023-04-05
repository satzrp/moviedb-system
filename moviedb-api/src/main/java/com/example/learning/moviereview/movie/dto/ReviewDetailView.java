package com.example.learning.moviereview.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ReviewDetailView(
        Integer id,
        String reviewContent,
        LocalDateTime createdAt,
        @JsonProperty(value = "movie")
        MovieView movieView) { }
