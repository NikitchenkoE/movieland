package com.repository.impl;

import com.entity.Genre;
import com.repository.GenreRepository;
import com.repository.mapper.GenreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepositoryJdbc implements GenreRepository {
    private static final String SELECT_ALL_GENRES = "SELECT genreID, genre FROM genres";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final GenreMapper genreMapper = new GenreMapper();

    @Override
    public List<Genre> getAllGenres() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_GENRES, genreMapper);
    }


}
