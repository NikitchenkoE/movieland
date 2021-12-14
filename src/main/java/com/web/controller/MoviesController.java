package com.web.controller;

import com.dto.MovieDto;
import com.dto.MovieRequestData;
import com.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movie")
    public List<MovieDto> getAllMovies(@RequestParam(name = "rating", required = false) String ratingRequestParam,
                                       @RequestParam(name = "price", required = false) String priceRequestParam) {
        return movieService.getAllMovies(MovieRequestData.builder()
                .ratingRequestInfo(ratingRequestParam)
                .priceRequestInfo(priceRequestParam)
                .build());
    }

    @GetMapping(value = "/movie/random")
    public List<MovieDto> getRandomMovies() {
        return movieService.getRandomMovies(3);
    }

    @GetMapping(value = "/movie/genre/{genreId}")
    public List<MovieDto> getMoviesByGenreId(@PathVariable("genreId") Long id,
                                             @RequestParam(name = "rating", required = false) String ratingRequestParam,
                                             @RequestParam(name = "price", required = false) String priceRequestParam) {
        return movieService.getMoviesByGenreId(MovieRequestData.builder()
                .ratingRequestInfo(ratingRequestParam)
                .priceRequestInfo(priceRequestParam)
                .genreId(id)
                .build());
    }
}
