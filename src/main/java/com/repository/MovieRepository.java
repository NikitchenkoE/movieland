package com.repository;

import com.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenreId(Long id);

    List<Movie> getAllMoviesSortedByRating();

    List<Movie> getMoviesByGenreIdSortedByRating(Long id);

}
