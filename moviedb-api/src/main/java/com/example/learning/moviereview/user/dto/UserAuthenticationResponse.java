package com.example.learning.moviereview.user.dto;

public record UserAuthenticationResponse(Integer id,
                                         String email,
                                         String token) { }
