package com.repository.impl;

import com.entity.Movie;
import com.repository.MovieRepository;
import com.repository.mapper.MovieExtendedInformationMapper;
import com.repository.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class MovieRepositoryJdbc implements MovieRepository {
    private static final String SELECT_ALL_MOVIES = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            "  picturePath, rating, price FROM movies";

    private static final String SELECT_ALL_MOVIES_ORDER_BY_RATING = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            "  picturePath, rating, price FROM movies ORDER BY rating DESC";

    private static final String SELECT_RANDOM_MOVIES = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            "  picturePath, rating, price FROM movies ORDER BY random() LIMIT :count";

    private static final String SELECT_MOVIES_BY_GENRE = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            "  m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID";

    private static final String SELECT_MOVIES_BY_GENRE_ORDER_BY_RATING = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            "  m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID ORDER BY m.rating DESC";

    private static final String SELECT_ALL_MOVIES_ORDER_BY_PRICE_DESC = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            "  picturePath, rating, price FROM movies ORDER BY price DESC";

    private static final String SELECT_ALL_MOVIES_ORDER_BY_PRICE_ASC = "SELECT movieID, nameRussian, nameNative, yearOfRelease," +
            "  picturePath, rating, price FROM movies ORDER BY price";

    private static final String SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_DESC = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            " m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID ORDER BY m.price DESC";

    private static final String SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_ASC = "SELECT m.movieID, m.nameRussian, m.nameNative, m.yearOfRelease," +
            "  m.picturePath, m.rating, m.price FROM movies m INNER JOIN moviegenrerelation rl on m.movieid = rl.movieid" +
            " WHERE rl.genreid = :genreID ORDER BY m.price";

    private static final String SELECT_MOVIE_EXTENDED_INFORMATION_BY_ID = """
            SELECT
            m.movieid, m.namerussian, m.namenative, m.yearofrelease, m.description, m.rating, m.price, m.picturepath,
            c.countryid, c.countryname,
            g.genreid, g.genre,
            r.reviewid, r.reviewtext,
            u.userid, u.userpersonaldetails
            FROM movies m
            INNER JOIN moviecountryrelation mcr on m.movieid = mcr.movieid INNER JOIN countries c on c.countryid = mcr.countryid
            INNER JOIN moviegenrerelation mgr on m.movieid = mgr.movieid INNER JOIN genres g on g.genreid = mgr.genreid
            LEFT JOIN reviews r on m.movieid = r.movieid
            LEFT JOIN users u on u.userid = r.userid
            WHERE m.movieid = :movieId""";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final MovieMapper movieMapper = new MovieMapper();


    public List<Movie> getAllMovies() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES, movieMapper);
    }

    public List<Movie> getRandomMovies(int count) {
        return namedParameterJdbcTemplate.query(SELECT_RANDOM_MOVIES, Collections.singletonMap("count", count), movieMapper);
    }

    public List<Movie> getMoviesByGenreId(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE, Collections.singletonMap("genreID", id), movieMapper);
    }

    public List<Movie> getAllMoviesSortedByRating() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES_ORDER_BY_RATING, movieMapper);
    }

    public List<Movie> getAllMoviesSortedByPriceDESC() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES_ORDER_BY_PRICE_DESC, movieMapper);
    }

    public List<Movie> getAllMoviesSortedByPriceASC() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_MOVIES_ORDER_BY_PRICE_ASC, movieMapper);
    }

    public List<Movie> getMoviesByGenreIdSortedByRating(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE_ORDER_BY_RATING, Collections.singletonMap("genreID", id), movieMapper);
    }

    public List<Movie> getMoviesByGenreIdSortedByPriceDESC(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_DESC, Collections.singletonMap("genreID", id), movieMapper);
    }

    public List<Movie> getMoviesByGenreIdSortedByPriceASC(Long id) {
        return namedParameterJdbcTemplate.query(SELECT_MOVIES_BY_GENRE_ORDER_BY_PRICE_ASC, Collections.singletonMap("genreID", id), movieMapper);
    }

    public Movie getMovieById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(SELECT_MOVIE_EXTENDED_INFORMATION_BY_ID, Collections.singletonMap("movieId", id), new MovieExtendedInformationMapper());
    }
}
