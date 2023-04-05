package com.example.learning.moviereview.common.event;

public record DomainEvent<T>(
        String eventId,
        Long eventTimestamp,
        T payload) { }
