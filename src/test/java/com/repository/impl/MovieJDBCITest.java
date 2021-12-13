package com.repository.impl;

import com.entity.Movie;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@Testcontainers
class MovieJDBCITest {

    private final MovieRepJdbc movieRep = new MovieRepJdbc();

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

        movieRep.setJdbcTemplate(new JdbcTemplate(dataSource));
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
}