package com.example.learning.moviereview.movie;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer yearOfRelease;
    private String description;
    private Integer runningLength;
    private String genre;

    @Column(name = "avatar")
    private String avatarUrl;

    private String imageUrl;
    private String actors;
    private String director;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Review> reviews;
}
