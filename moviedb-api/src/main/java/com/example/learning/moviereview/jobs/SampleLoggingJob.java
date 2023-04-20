package com.example.learning.moviereview.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class SampleLoggingJob {
    @Scheduled(fixedRate = 1000 * 10 * 10)
    public void scheduleInfoLog() {
        log.info("Logging at: {}", LocalDateTime.now());
    }
}
