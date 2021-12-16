package com.model.impl;

import com.config.SpringTestContext;
import com.config.WebConfig;
import com.dto.MovieDto;
import com.dto.MovieExtendedInformationDto;
import com.dto.MovieRequestData;
import com.model.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, SpringTestContext.class})
class MovieServiceImplTest {
    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies() {
        List<MovieDto> allMovies = movieService.getAllMovies(new MovieRequestData());
        assertEquals(25, allMovies.size());
        assertEquals(allMovies.get(1).getClass(), MovieDto.class);
    }

    @Test
    void getRandomMovies() {
        List<MovieDto> allMovies = movieService.getRandomMovies(MovieRequestData.builder().countOfRandomMovies(2).build());
        assertEquals(2, allMovies.size());
        assertEquals(allMovies.get(1).getClass(), MovieDto.class);
    }

    @Test
    void getMoviesByGenreId() {
        List<MovieDto> allMovies = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .genreId(1L)
                .build());
        assertEquals(16, allMovies.size());
    }

    @Test
    void getAllMoviesSortedByRating() {
        List<MovieDto> moviesSortedByRating = movieService.getAllMovies(MovieRequestData.builder()
                .ratingRequestInfo("desc")
                .build());
        for (int i = 0; i < moviesSortedByRating.size() - 1; i++) {
            assertTrue(moviesSortedByRating.get(i).getRating() >= moviesSortedByRating.get(i + 1).getRating());
        }
    }

    @Test
    void getAllMoviesSortedByRatingCapital() {
        List<MovieDto> moviesSortedByRating = movieService.getAllMovies(MovieRequestData.builder()
                .ratingRequestInfo("DESC")
                .build());
        for (int i = 0; i < moviesSortedByRating.size() - 1; i++) {
            assertTrue(moviesSortedByRating.get(i).getRating() >= moviesSortedByRating.get(i + 1).getRating());
        }
    }

    @Test
    void getAllMoviesSortedByPriceAsc() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("asc")
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() <= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getAllMoviesSortedByPriceAscCapital() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("ASC")
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() <= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getAllMoviesSortedByPriceDesc() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("desc")
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() >= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getAllMoviesSortedByPriceCapital() {
        List<MovieDto> moviesSortedByPrice = movieService.getAllMovies(MovieRequestData.builder()
                .priceRequestInfo("DESC")
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() >= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getMoviesByGenreIdSortedByRating() {
        List<MovieDto> moviesSortedByRating = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .ratingRequestInfo("desc")
                .genreId(1L)
                .build());
        for (int i = 0; i < moviesSortedByRating.size() - 1; i++) {
            assertTrue(moviesSortedByRating.get(i).getRating() >= moviesSortedByRating.get(i + 1).getRating());
        }
    }

    @Test
    void getMoviesByGenreIdSortedByRatingCapital() {
        List<MovieDto> moviesSortedByRating = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .ratingRequestInfo("DESC")
                .genreId(1L)
                .build());
        for (int i = 0; i < moviesSortedByRating.size() - 1; i++) {
            assertTrue(moviesSortedByRating.get(i).getRating() >= moviesSortedByRating.get(i + 1).getRating());
        }
    }

    @Test
    void getMoviesByGenreIdSortedByPriceASC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("asc")
                .genreId(1L)
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() <= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getMoviesByGenreIdSortedByPriceCapitalASC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("ASC")
                .genreId(1L)
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() <= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getMoviesByGenreIdSortedByPriceDESC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("desc")
                .genreId(1L)
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() >= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void getMoviesByGenreIdSortedByPriceCapitalDESC() {
        List<MovieDto> moviesSortedByPrice = movieService.getMoviesByGenreId(MovieRequestData.builder()
                .priceRequestInfo("DESC")
                .genreId(1L)
                .build());
        for (int i = 0; i < moviesSortedByPrice.size() - 1; i++) {
            assertTrue(moviesSortedByPrice.get(i).getPrice() >= moviesSortedByPrice.get(i + 1).getPrice());
        }
    }

    @Test
    void testGetMovieByIdShouldReturnMovieExtendedInformationDto() {
        MovieExtendedInformationDto movieActual = movieService.getMovieById(MovieRequestData.builder().movieId(1L).build());
        assertEquals(1L, movieActual.getId());
    }

}