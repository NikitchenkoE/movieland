package com.repository.impl;

import com.entity.Movie;
import com.repository.MovieRepository;
import com.repository.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MovieRepJdbc implements MovieRepository {
    private static final String SELECT_ALL_MOVIES = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies";

    private static final String SELECT_ALL_MOVIES_ORDER_BY_RATING = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies ORDER BY rating DESC";

    private static final String SELECT_RANDOM_MOVIES = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies ORDER BY random() LIMIT :count";

    private static final String SELECT_MOVIES_BY_GENRE = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            " m.country, m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID";

    private static final String SELECT_MOVIES_BY_GENRE_ORDER_BY_RATING = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            " m.country, m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID ORDER BY m.rating DESC";

    private static final String SELECT_ALL_MOVIES_ORDER_BY_PRICE_DESC = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies ORDER BY price DESC";

    private static final String SELECT_ALL_MOVIES_ORDER_BY_PRICE_ASC = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            " country, picturePath, rating, price FROM movies ORDER BY price";

    private static final String SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_DESC = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            " m.country, m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID ORDER BY m.price DESC";

    private static final String SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_ASC = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            " m.country, m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID ORDER BY m.price";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Movie> getAllMovies() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES, new MovieMapper());
    }

    public List<Movie> getRandomMovies(int count) {
        return namedParameterJdbcTemplate.query(SELECT_RANDOM_MOVIES, Collections.singletonMap("count", count), new MovieMapper());
    }

    public List<Movie> getMoviesByGenreId(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE, Collections.singletonMap("genreID", id), new MovieMapper());
    }

    public List<Movie> getAllMoviesSortedByRating() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES_ORDER_BY_RATING, new MovieMapper());
    }

    public List<Movie> getAllMoviesSortedByPriceDESC() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES_ORDER_BY_PRICE_DESC, new MovieMapper());
    }

    public List<Movie> getAllMoviesSortedByPriceASC() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES_ORDER_BY_PRICE_ASC, new MovieMapper());
    }

    public List<Movie> getMoviesByGenreIdSortedByRating(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE_ORDER_BY_RATING, Collections.singletonMap("genreID", id), new MovieMapper());
    }

    public List<Movie> getMoviesByGenreIdSortedByPriceDESC(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_DESC, Collections.singletonMap("genreID", id), new MovieMapper());
    }

    public List<Movie> getMoviesByGenreIdSortedByPriceASC(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_ASC, Collections.singletonMap("genreID", id), new MovieMapper());
    }
}
