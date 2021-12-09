package com.web;

import com.entity.dto.MovieDto;
import com.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/api/v1/movie")
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/movie/random")
    public ResponseEntity<List<MovieDto>> getRandomMovies() {
        List<MovieDto> randomMovies = movieService.getRandomMovies(3);
        return new ResponseEntity<>(randomMovies, HttpStatus.OK);
    }
}
