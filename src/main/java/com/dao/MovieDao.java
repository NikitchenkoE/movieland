package com.dao;

import com.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);
}
