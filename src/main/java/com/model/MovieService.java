package com.model;

import com.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();

    List<MovieDto> getRandomMovies(int count);

    List<MovieDto> getMoviesByGenreId(Long id);
}
