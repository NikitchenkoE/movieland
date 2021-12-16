package com.repository;

import com.entity.Movie;
import com.entity.SortMethod;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenreId(Long id);

    List<Movie> getAllMoviesSortedByRating(SortMethod sortMethod);

    List<Movie> getMoviesByGenreIdSortedByRating(Long id, SortMethod sortMethod);

    List<Movie> getAllMoviesSortedByPrice(SortMethod sortMethod);

    List<Movie> getMoviesByGenreIdSortedByPrice(Long id, SortMethod sortMethod);

    Movie getMovieById(Long id);

}
