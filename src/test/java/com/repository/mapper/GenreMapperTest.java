package com.repository.mapper;

import com.entity.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenreMapperTest {
    GenreMapper genreMapper = new GenreMapper();
    @Mock
    ResultSet resultSet;

    @Test
    void testMapRowShouldReturnGenreEntity() throws SQLException {
        when(resultSet.getLong("genreID")).thenReturn(1L);
        when(resultSet.getString("genre")).thenReturn("Drama");

        Genre genreExpected = Genre.builder()
                .id(1L)
                .name("Drama")
                .build();

        Genre actual = genreMapper.mapRow(resultSet, 2);

        assertEquals(genreExpected, actual);
    }
}