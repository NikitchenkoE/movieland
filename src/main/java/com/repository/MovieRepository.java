package com.repository;

import com.entity.Movie;
import com.entity.MovieExtendedInformation;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenreId(Long id);

    List<Movie> getAllMoviesSortedByRating();

    List<Movie> getMoviesByGenreIdSortedByRating(Long id);

    List<Movie> getAllMoviesSortedByPriceDESC();

    List<Movie> getAllMoviesSortedByPriceASC();

    List<Movie> getMoviesByGenreIdSortedByPriceDESC(Long id);

    List<Movie> getMoviesByGenreIdSortedByPriceASC(Long id);

    MovieExtendedInformation getMovieById(Long id);

}
