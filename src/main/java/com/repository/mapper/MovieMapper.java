package com.repository.mapper;

import com.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class MovieMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Movie.builder()
                .id(resultSet.getLong("movieID"))
                .nameRussian(resultSet.getString("nameRussian"))
                .nameNative(resultSet.getString("nameNative"))
                .yearOfRelease(resultSet.getInt("yearOfRelease"))
                .country(resultSet.getString("country"))
                .picturePath(resultSet.getString("picturePath"))
                .rating(resultSet.getDouble("rating"))
                .price(resultSet.getDouble("price"))
                .build();
    }
}
