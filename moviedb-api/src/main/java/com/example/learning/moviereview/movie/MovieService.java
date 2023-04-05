package com.example.learning.moviereview.movie;

import com.example.learning.moviereview.movie.exceptions.MovieNotFoundException;
import com.example.learning.moviereview.user.User;
import com.example.learning.moviereview.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;
    private final UserService userService;

    public MovieService(MovieRepository movieRepository,
                        ReviewRepository reviewRepository,
                        UserService userService) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public Movie getMovieById(Integer movieId) throws MovieNotFoundException {
        Optional<Movie> movie = this.movieRepository.findById(movieId);
        return movie.orElseThrow(() ->
                new MovieNotFoundException("movie with id " + movieId + " doesn't exist")
        );
    }

    public List<Review> getReviewsByUser(Integer userId) {
        return reviewRepository.findAllByUserId(userId);
    }

    public Review addNewReview(Integer movieId, Integer userId, String reviewContent) {
        LocalDateTime currentTimestamp = LocalDateTime.now();
        Movie movie = movieRepository.getReferenceById(movieId);
        User user = userService.getUserReference(userId);
        Review newReview = Review.builder()
                .movie(movie)
                .user(user)
                .reviewContent(reviewContent)
                .createdAt(currentTimestamp)
                .updatedAt(currentTimestamp)
                .build();
        return reviewRepository.save(newReview);
    }
}
