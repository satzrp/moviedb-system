package com.example.learning.moviereview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MovieDbApplication {
	public static void main(String... args) {
		SpringApplication.run(MovieDbApplication.class, args);
	}
}
