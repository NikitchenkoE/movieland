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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

class CachedGenreServiceImplTest {
    private static final GenreRepJdbc genreRepJdbc = mock(GenreRepJdbc.class);
    private static final GenreServiceImpl genreService = new GenreServiceImpl(genreRepJdbc, new GenreMapperImpl());
    private static final GenreService cachedGenreService = new CachedGenreServiceImpl(genreService);
    private static final List<Genre> genreListOldData = Arrays.asList(new Genre(1L, "drama"), new Genre(2L, "comedy"));
    private static final List<Genre> genreListNewData = Arrays.asList(new Genre(1L, "comedy"), new Genre(2L, "drama"));

    @BeforeAll
    static void init() {
        Mockito.when(genreRepJdbc.getAllGenres()).thenReturn(genreListOldData).thenReturn(genreListNewData);
    }

    @Test
    void testTryToGetDataAfterChangeShouldReturnOldData() {
        List<GenreDto> allGenreDtoOldData = cachedGenreService.getAllGenreDto();
        List<GenreDto> allGenreDtoNewData = cachedGenreService.getAllGenreDto();
        assertEquals(allGenreDtoOldData, allGenreDtoNewData);
    }

    @Test
    void testTryToGetDataAfterChangeShouldReturnNewData() {
        List<GenreDto> allGenreDtoOldData = genreService.getAllGenreDto();
        List<GenreDto> allGenreDtoNewData = genreService.getAllGenreDto();
        assertNotEquals(allGenreDtoOldData, allGenreDtoNewData);
    }
}
