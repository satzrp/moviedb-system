package com.example.learning.moviereview.movie;

import com.example.learning.moviereview.movie.dto.AddReviewRequest;
import com.example.learning.moviereview.movie.dto.MovieDetailView;
import com.example.learning.moviereview.movie.dto.MovieView;
import com.example.learning.moviereview.movie.dto.ReviewDetailView;
import com.example.learning.moviereview.movie.exceptions.MovieNotFoundException;
import com.example.learning.moviereview.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.learning.moviereview.mapper.MovieMapper.movieToMovieDetailView;
import static com.example.learning.moviereview.mapper.MovieMapper.moviesToMovieViews;
import static com.example.learning.moviereview.mapper.ReviewMapper.reviewsToReviewDetailViews;

@Slf4j
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieView>> getAllMovies() {
        var movies = moviesToMovieViews(this.movieService.getAllMovies());
        return ResponseEntity.ok(movies);
    }

    // TODO: send valid response for MovieNotFoundException
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDetailView> getMovieById(@PathVariable Integer movieId) throws MovieNotFoundException {
        var movie = movieToMovieDetailView(this.movieService.getMovieById(movieId));
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/reviews/{userId}")
    public ResponseEntity<List<ReviewDetailView>> getReviewsByUser(@PathVariable Integer userId) {
        var reviews = movieService.getReviewsByUser(userId);
        return ResponseEntity.ok(reviewsToReviewDetailViews(reviews));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{movieId}/reviews")
    public ResponseEntity<String> addNewReview(
            @PathVariable Integer movieId, @RequestBody AddReviewRequest addReviewRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = (User) authentication.getPrincipal();
        movieService.addNewReview(movieId, user.getId(), addReviewRequest.reviewContent());
        return ResponseEntity.status(HttpStatus.CREATED).body("Review add successfully");
    }
}