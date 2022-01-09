package com.web.controller;

import com.dto.MovieAddDto;
import com.dto.MovieDto;
import com.dto.MovieExtendedInformationDto;
import com.dto.MovieRequestData;
import com.model.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
        return movieService.getRandomMovies(MovieRequestData.builder().countOfRandomMovies(3).build());
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

    @GetMapping("/movie/{movieId}")
    public MovieExtendedInformationDto getMovieById(@PathVariable(name = "movieId") Long movieId,
                                                    @RequestParam(name = "currency", required = false) String currencyInfo) {
        return movieService.getMovieById(MovieRequestData.builder()
                .movieId(movieId)
                .currencyInfo(currencyInfo)
                .build());
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/movie")
    public void addNewMovie(@RequestBody MovieAddDto movieAddDto){

        movieService.addMovie(movieAddDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/movie/{id}")
    public void updateMovieMovie(@RequestBody MovieAddDto movieAddDto, @PathVariable(value = "id") Long id){
        movieAddDto.setId(id);
        movieService.addMovie(movieAddDto);
    }
}
