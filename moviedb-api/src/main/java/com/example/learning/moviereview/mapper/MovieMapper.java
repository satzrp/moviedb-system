package com.example.learning.moviereview.mapper;

import com.example.learning.moviereview.movie.Movie;
import com.example.learning.moviereview.movie.dto.MovieDetailView;
import com.example.learning.moviereview.movie.dto.MovieView;

import java.util.List;

import static com.example.learning.moviereview.mapper.ReviewMapper.reviewsToReviewViews;

public class MovieMapper {

    private MovieMapper() {}

    public static MovieView movieToMovieView(Movie movie) {
        return new MovieView(
                movie.getId(), movie.getName(), movie.getYearOfRelease(),
                movie.getDescription(), movie.getRunningLength(), movie.getGenre(),
                movie.getAvatarUrl(), movie.getImageUrl(), movie.getActors(), movie.getDirector()
        );
    }

    public static List<MovieView> moviesToMovieViews(List<Movie> movies) {
        return movies
                .stream()
                .map(MovieMapper::movieToMovieView)
                .toList();
    }

    public static MovieDetailView movieToMovieDetailView(Movie movie) {
        return new MovieDetailView(movieToMovieView(movie), reviewsToReviewViews(movie.getReviews()));
    }
}
