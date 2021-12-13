package com.repository.impl;

import com.entity.Genre;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class GenreRepJdbcTest {

    private final GenreRepJdbc genreRepJdbc= new GenreRepJdbc();

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

        genreRepJdbc.setJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Test
    void testGetAllGenresReturnAllGenres() {
        List<Genre> genres = genreRepJdbc.getAllGenres();

        assertEquals(15, genres.size());
        assertEquals("драма", genres.get(0).getName());
        assertEquals("комедия", genres.get(6).getName());
        assertEquals("вестерн", genres.get(14).getName());
    }
}