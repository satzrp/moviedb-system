package com.example.learning.moviereview.movie.dto;

import com.example.learning.moviereview.user.dto.UserView;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ReviewView(
        Integer id,
        String reviewContent,
        LocalDateTime createdAt,
        @JsonProperty(value = "user")
        UserView userView) { }
