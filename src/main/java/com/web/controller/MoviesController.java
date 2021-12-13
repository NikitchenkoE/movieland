package com.web.controller;

import com.dto.MovieDto;
import com.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/movie/random")
    public List<MovieDto> getRandomMovies() {
        return movieService.getRandomMovies(3);
    }

    @GetMapping(value = "/movie/genre/{genreId}")
    public List<MovieDto> getMoviesByGenreId(@PathVariable("genreId") Long id) {
        return movieService.getMoviesByGenreId(id);
    }
}
