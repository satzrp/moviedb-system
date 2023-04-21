package com.example.learning.moviereview.common.response;

public record ApiResponse<T> (
        T payload,
        String message,
        String status) { }
