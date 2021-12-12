package com.web.controller;

import com.dto.MovieDto;
import com.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/api/movie")
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/api/movie/random")
    public List<MovieDto> getRandomMovies() {
        return movieService.getRandomMovies(3);
    }
}
