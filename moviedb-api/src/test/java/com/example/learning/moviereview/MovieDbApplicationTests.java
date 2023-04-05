package com.example.learning.moviereview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MovieDbApplicationTests {

	@Test
	void contextLoads() {
		boolean actual = true;
		assertThat(actual).isTrue();
	}

}
