package com.repository.impl;

import com.entity.Movie;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class MovieJDBCITest {

    private MovieRepJdbc movieRep;

    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.3"))
            .withUsername("username")
            .withPassword("password")
            .withDatabaseName("testDb");

    @BeforeEach
    void init() {
        var config = new HikariConfig();
        config.setUsername(container.getUsername());
        config.setPassword(container.getPassword());
        config.setJdbcUrl(container.getJdbcUrl());
        config.setDriverClassName(container.getDriverClassName());
        var dataSource = new HikariDataSource(config);

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();

        movieRep = new MovieRepJdbc(new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource)));
    }

    @Test
    void testGetAllMoviesReturnRightNumberOfMovies() {
        List<Movie> allMovies = movieRep.getAllMovies();
        assertEquals(25, allMovies.size());
        assertNotEquals(1, allMovies.size());
        assertNotEquals(5, allMovies.size());
        assertNotEquals(30, allMovies.size());
    }

    @Test
    void testGetAllMoviesReturnRightFirstMovies() {
        List<Movie> allMovies = movieRep.getAllMovies();
        assertEquals("Побег из Шоушенка", allMovies.get(0).getNameRussian());
        assertEquals("The Shawshank Redemption", allMovies.get(0).getNameNative());
    }

    @Test
    void testGetAllMoviesReturnRightLastMovies() {
        List<Movie> allMovies = movieRep.getAllMovies();
        assertEquals("Танцующий с волками", allMovies.get(24).getNameRussian());
        assertEquals("Dances with Wolves", allMovies.get(24).getNameNative());
    }

    @Test
    void testGetRandomMovieReturnRightNumberOfMovies() {
        var tenMovies = movieRep.getRandomMovies(10);
        var oneMovie = movieRep.getRandomMovies(1);
        var twentyFiveMovies = movieRep.getRandomMovies(25);

        assertEquals(1, oneMovie.size());
        assertEquals(10, tenMovies.size());
        assertEquals(25, twentyFiveMovies.size());
    }

    @Test
    void testGetAllMoviesByGenreId() {
        assertEquals(16, movieRep.getMoviesByGenreId(1L).size());
        assertEquals(3, movieRep.getMoviesByGenreId(4L).size());
        assertEquals(3, movieRep.getMoviesByGenreId(15L).size());
        assertEquals(6, movieRep.getMoviesByGenreId(11L).size());
    }

    @Test
    void testGetAllMoviesOrderByRating() {
        List<Movie> allMoviesSortedByRating = movieRep.getAllMoviesSortedByRating();
        for (int i = 0; i < allMoviesSortedByRating.size() - 1; i++) {
            Movie thisMovie = allMoviesSortedByRating.get(i);
            Movie nextMovie = allMoviesSortedByRating.get(i + 1);
            assertTrue(thisMovie.getRating() >= nextMovie.getRating());
        }
    }

    @Test
    void testGetAllMoviesByGenreOrderByRating() {
        List<Movie> moviesByGenreSortedByRating = movieRep.getMoviesByGenreIdSortedByRating(1L);
        for (int i = 0; i < moviesByGenreSortedByRating.size() - 1; i++) {
            Movie thisMovie = moviesByGenreSortedByRating.get(i);
            Movie nextMovie = moviesByGenreSortedByRating.get(i + 1);
            assertTrue(thisMovie.getRating() >= nextMovie.getRating());
        }
    }
}