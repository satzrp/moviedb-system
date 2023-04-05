package com.example.learning.moviereview.movie.dto;

import java.util.List;

public record MovieDetailView(MovieView movieDetails,
                              List<ReviewView> reviews) { }
