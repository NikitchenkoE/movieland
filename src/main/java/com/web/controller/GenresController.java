package com.web.controller;

import com.dto.GenreDto;
import com.model.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class GenresController {
    private final GenreService genreService;

    @GetMapping("/genre")
    public List<GenreDto> getAllGenresDto() {
        return genreService.getAllGenreDto();
    }
}
