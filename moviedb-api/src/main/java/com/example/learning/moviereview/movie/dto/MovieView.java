package com.example.learning.moviereview.movie.dto;

public record MovieView(
        Integer id,
        String name,
        Integer yearOfRelease,
        String description,
        Integer runningLength,
        String genre,
        String avatarUrl,
        String imageUrl,
        String actors,
        String director) { }
