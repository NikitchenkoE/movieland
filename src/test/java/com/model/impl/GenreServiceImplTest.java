package com.model.impl;

import com.dto.GenreDto;
import com.model.GenreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GenreServiceImplTest {

    @Autowired
    private GenreService genreService;

    @Test
    void getAllGenreDto() {
        List<GenreDto> allGenreDto = genreService.getAllGenreDto();
        System.out.println(allGenreDto);
    }
}