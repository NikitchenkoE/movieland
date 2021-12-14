package com.model;

import com.dto.MovieDto;
import com.dto.MovieRequestData;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies(MovieRequestData movieRequestData);

    List<MovieDto> getRandomMovies(MovieRequestData movieRequestData);

    List<MovieDto> getMoviesByGenreId(MovieRequestData movieRequestData);
}
