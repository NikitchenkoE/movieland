package com.model;

import com.dto.MovieAddDto;
import com.dto.MovieDto;
import com.dto.MovieExtendedInformationDto;
import com.dto.MovieRequestData;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies(MovieRequestData movieRequestData);

    List<MovieDto> getRandomMovies(MovieRequestData movieRequestData);

    List<MovieDto> getMoviesByGenreId(MovieRequestData movieRequestData);

    MovieExtendedInformationDto getMovieById(MovieRequestData movieRequestData);

    void addMovie(MovieAddDto movieAddDto);
}
