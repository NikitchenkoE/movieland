package com.repository.impl;

import com.entity.Genre;
import com.repository.GenreRepository;
import com.repository.mapper.GenreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepJdbc implements GenreRepository {
    private static final String SELECT_ALL_GENRES = "SELECT genreID, genre FROM genres";
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Genre> getAllGenres() {
        return jdbcTemplate.query(SELECT_ALL_GENRES, new GenreMapper());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
