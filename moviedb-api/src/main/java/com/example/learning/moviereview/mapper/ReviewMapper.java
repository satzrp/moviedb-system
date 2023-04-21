package com.example.learning.moviereview.mapper;

import com.example.learning.moviereview.movie.Review;
import com.example.learning.moviereview.movie.dto.ReviewDetailView;
import com.example.learning.moviereview.movie.dto.ReviewView;

import java.util.Comparator;
import java.util.List;

import static com.example.learning.moviereview.mapper.MovieMapper.movieToMovieView;
import static com.example.learning.moviereview.mapper.UserMapper.userToUserView;

public class ReviewMapper {

    private ReviewMapper() {}

    public static ReviewView reviewToReviewView(Review review) {
        return new ReviewView(
                review.getId(),
                review.getReviewContent(),
                review.getCreatedAt(),
                userToUserView(review.getUser()));
    }

    public static List<ReviewView> reviewsToReviewViews(List<Review> reviews) {
        return reviews
                .stream()
                .map(ReviewMapper::reviewToReviewView)
                .sorted((reviewOne, reviewTwo) -> reviewTwo.createdAt().compareTo(reviewOne.createdAt()))
                .toList();
    }

    public static ReviewDetailView reviewToReviewDetailView(Review review) {
        return new ReviewDetailView(
                review.getId(),
                review.getReviewContent(),
                review.getCreatedAt(),
                movieToMovieView(review.getMovie())
        );
    }

    public static List<ReviewDetailView> reviewsToReviewDetailViews(List<Review> reviews) {
        return reviews
                .stream()
                .map(ReviewMapper::reviewToReviewDetailView)
                .toList();
    }
}
