package com.web.controller;

import com.dto.GenreDto;
import com.model.GenreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenresController {
    private final GenreService genreService;

    public GenresController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genre")
    public List<GenreDto> getAllGenresDto() {
        return genreService.getAllGenreDto();
    }
}
