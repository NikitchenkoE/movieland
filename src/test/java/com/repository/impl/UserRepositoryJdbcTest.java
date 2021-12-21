package com.repository.impl;

import com.entity.User;
import com.entity.UserRole;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
class UserRepositoryJdbcTest {

    private static UserRepositoryJdbc userRepositoryJdbc;

    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.3"))
            .withUsername("username")
            .withPassword("password")
            .withDatabaseName("testDb");

    @BeforeAll
    static void init() {
        var hikariConfig = new HikariConfig();
        hikariConfig.setUsername(container.getUsername());
        hikariConfig.setPassword(container.getPassword());
        hikariConfig.setJdbcUrl(container.getJdbcUrl());
        hikariConfig.setDriverClassName(container.getDriverClassName());
        var dataSource = new HikariDataSource(hikariConfig);

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();

        userRepositoryJdbc = new UserRepositoryJdbc(new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource)));
    }

    @Test
    void getUserByEmail() {
        User userByEmail = userRepositoryJdbc.getUserByEmail("ronald.reynolds66@example.com");
        assertEquals("Рональд Рейнольдс", userByEmail.getNickname());
        assertEquals("ronald.reynolds66@example.com", userByEmail.getEmail());
        assertEquals("$2a$08$F5rK18KV86WFOEOtUBXb3Odl53xlm2ww9FnJXHmEloIZyaCAaEo.W", userByEmail.getPassword());
        assertEquals(UserRole.ROLE_USER, userByEmail.getUserRole());

    }
}