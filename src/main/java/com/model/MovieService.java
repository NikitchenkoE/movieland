package com.model;

import com.entity.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();

    List<MovieDto> getRandomMovies(int count);
}
