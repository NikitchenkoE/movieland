package com.model.impl;

import com.dto.MovieDto;
import com.dto.MovieRequestData;
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
    private static final List<Movie> movieActualSortedByRating = Arrays.asList(Movie.builder().id(1L).build(), Movie.builder().id(2L).build());
    private static final List<Movie> movieActualSortedByPriceASC = Arrays.asList(Movie.builder().id(3L).build(), Movie.builder().id(4L).build());
    private static final List<Movie> movieActualSortedByPriceDESC = Arrays.asList(Movie.builder().id(5L).build(), Movie.builder().id(6L).build());
    private static final List<MovieDto> movieExpected = Arrays.asList(MovieDto.builder().id(1L).build(), MovieDto.builder().id(2L).build());
    private static final List<MovieDto> movieExpectedSortedByRating = Arrays.asList(MovieDto.builder().id(1L).build(), MovieDto.builder().id(2L).build());
    private static final List<MovieDto> movieExpectedSortedByPriceASC = Arrays.asList(MovieDto.builder().id(3L).build(), MovieDto.builder().id(4L).build());
    private static final List<MovieDto> movieExpectedSortedByPriceDESC = Arrays.asList(MovieDto.builder().id(5L).build(), MovieDto.builder().id(6L).build());

    @BeforeAll
    static void init() {
        Mockito.when(movieDao.getAllMovies()).thenReturn(movieActual);
        Mockito.when(movieDao.getMoviesByGenreId(1L)).thenReturn(movieActual);
        Mockito.when(movieDao.getRandomMovies(2)).thenReturn(movieActual);
        Mockito.when(movieDao.getAllMoviesSortedByRating()).thenReturn(movieActualSortedByRating);
        Mockito.when(movieDao.getAllMoviesSortedByPriceASC()).thenReturn(movieActualSortedByPriceASC);
        Mockito.when(movieDao.getAllMoviesSortedByPriceDESC()).thenReturn(movieActualSortedByPriceDESC);
        Mockito.when(movieDao.getMoviesByGenreIdSortedByRating(1L)).thenReturn(movieActualSortedByRating);
        Mockito.when(movieDao.getMoviesByGenreIdSortedByPriceASC(1L)).thenReturn(movieActualSortedByPriceASC);
        Mockito.when(movieDao.getMoviesByGenreIdSortedByPriceDESC(1L)).thenReturn(movieActualSortedByPriceDESC);
    }

    @Test
    void getAllMovies() {
        List<MovieDto> allMovies = movieService.getAllMovies(new MovieRequestData());
        assertEquals(movieExpected, allMovies);
    }

    @Test
    void getRandomMovies() {
        List<MovieDto> allMovies = movieService.getRandomMovies(MovieRequestData.builder().countOfRandomMovies(2).build());
        assertEquals(movieExpected, allMovies);
    }

    @Test
    void getMoviesByGenreId() {
        List<MovieDto> allMovies = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .genreId(1L)
                .build());
        assertEquals(movieExpected, allMovies);
    }

    @Test
    void getAllMoviesSortedByRating() {
        List<MovieDto> moviesSortedByRating = movieService.getAllMovies(MovieRequestData.builder()
                .ratingRequestInfo("desc")
                .build());
        assertEquals(movieExpectedSortedByRating, moviesSortedByRating);
    }

    @Test
    void getAllMoviesSortedByRatingCapital() {
        List<MovieDto> moviesSortedByRating = movieService.getAllMovies(MovieRequestData.builder()
                .ratingRequestInfo("DESC")
                .build());
        assertEquals(movieExpectedSortedByRating, moviesSortedByRating);
    }

    @Test
    void getAllMoviesSortedByPriceAsc() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("asc")
                .build());
        assertEquals(movieExpectedSortedByPriceASC, moviesSortedByPrice);
    }

    @Test
    void getAllMoviesSortedByPriceAscCapital() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("ASC")
                .build());
        assertEquals(movieExpectedSortedByPriceASC, moviesSortedByPrice);
    }

    @Test
    void getAllMoviesSortedByPriceDesc() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("desc")
                .build());
        assertEquals(movieExpectedSortedByPriceDESC, moviesSortedByPrice);
    }

    @Test
    void getAllMoviesSortedByPriceCapital() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("DESC")
                .build());
        assertEquals(movieExpectedSortedByPriceDESC, moviesSortedByPrice);
    }

    @Test
    void getMoviesByGenreIdSortedByRating() {
        List<MovieDto> moviesSortedByRating = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .ratingRequestInfo("desc")
                .genreId(1L)
                .build());
        assertEquals(movieExpectedSortedByRating, moviesSortedByRating);
    }

    @Test
    void getMoviesByGenreIdSortedByRatingCapital() {
        List<MovieDto> moviesSortedByRating = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .ratingRequestInfo("DESC")
                .genreId(1L)
                .build());
        assertEquals(movieExpectedSortedByRating, moviesSortedByRating);
    }

    @Test
    void getMoviesByGenreIdSortedByPriceASC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("asc")
                .genreId(1L)
                .build());
        assertEquals(movieExpectedSortedByPriceASC, moviesSortedByPrice);
    }

    @Test
    void getMoviesByGenreIdSortedByPriceCapitalASC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("ASC")
                .genreId(1L)
                .build());
        assertEquals(movieExpectedSortedByPriceASC, moviesSortedByPrice);
    }

    @Test
    void getMoviesByGenreIdSortedByPriceDESC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("desc")
                .genreId(1L)
                .build());
        assertEquals(movieExpectedSortedByPriceDESC, moviesSortedByPrice);
    }

    @Test
    void getMoviesByGenreIdSortedByPriceCapitalDESC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("DESC")
                .genreId(1L)
                .build());
        assertEquals(movieExpectedSortedByPriceDESC, moviesSortedByPrice);
    }

}