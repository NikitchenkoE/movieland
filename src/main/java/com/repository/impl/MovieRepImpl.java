package com.repository.impl;

import com.repository.MovieRepository;
import com.repository.mapper.MovieMapper;
import com.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class MovieRepImpl implements MovieRepository {
    private static final String SELECT_ALL_MOVIES = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies";
    private static final String SELECT_RANDOM_MOVIES = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies ORDER BY random() LIMIT :count";
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Movie> getAllMovies() {
        return jdbcTemplate.query(SELECT_ALL_MOVIES, new MovieMapper());
    }

    public List<Movie> getRandomMovies(int count) {
        return namedParameterJdbcTemplate.query(SELECT_RANDOM_MOVIES, Collections.singletonMap("count", count), new MovieMapper());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }
}
