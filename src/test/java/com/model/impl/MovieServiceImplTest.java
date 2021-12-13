package com.model.impl;

import com.dto.MovieDto;
import com.entity.Movie;
import com.model.mapper.MovieMapperImpl;
import com.repository.MovieRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MovieServiceImplTest {
    private static final MovieRepository movieDao = mock(MovieRepository.class);
    private static final MovieServiceImpl movieService = new MovieServiceImpl(movieDao, new MovieMapperImpl());
    private static final List<Movie> movieActual = Arrays.asList(Movie.builder().id(1L).build(), Movie.builder().id(2L).build());
    private static final List<MovieDto> movieExpected = Arrays.asList(MovieDto.builder().id(1L).build(), MovieDto.builder().id(2L).build());

    @BeforeAll
    static void init() {
        Mockito.when(movieDao.getAllMovies()).thenReturn(movieActual);
        Mockito.when(movieDao.getMoviesByGenreId(1L)).thenReturn(movieActual);
        Mockito.when(movieDao.getRandomMovies(2)).thenReturn(movieActual);
    }

    @Test
    void getAllMovies() {
        List<MovieDto> allMovies = movieService.getAllMovies();
        assertEquals(movieExpected, allMovies);
    }

    @Test
    void getRandomMovies() {
        List<MovieDto> allMovies = movieService.getRandomMovies(2);
        assertEquals(movieExpected, allMovies);
    }

    @Test
    void getMoviesByGenreId() {
        List<MovieDto> allMovies = movieService.getMoviesByGenreId(1L);
        assertEquals(movieExpected, allMovies);
    }

}