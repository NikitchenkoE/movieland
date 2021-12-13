package com.model.impl;

import com.dto.GenreDto;
import com.entity.Genre;
import com.model.GenreService;
import com.model.mapper.GenreMapperImpl;
import com.repository.impl.GenreRepJdbc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GenreServiceImplTest {

    private static final GenreRepJdbc genreRepJdbc = mock(GenreRepJdbc.class);
    private static final GenreService genreService = new GenreServiceImpl(genreRepJdbc, new GenreMapperImpl());
    private static final List<Genre> genreList = Arrays.asList(new Genre(1L, "drama"), new Genre(2L, "comedy"));
    private static final List<GenreDto> genreDtoList = Arrays.asList(new GenreDto(1L, "drama"), new GenreDto(2L, "comedy"));

    @BeforeAll
    static void init() {
        Mockito.when(genreRepJdbc.getAllGenres()).thenReturn(genreList);
    }

    @Test
    void getAllGenreDto() {
        List<GenreDto> allGenreDto = genreService.getAllGenreDto();
        assertEquals(genreDtoList, allGenreDto);
    }
}