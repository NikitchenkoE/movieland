package com.repository.impl;

import com.entity.*;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class MovieJDBCITest {

    private MovieRepositoryJdbc movieRep;

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

        movieRep = new MovieRepositoryJdbc(new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource)));
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

    @Test
    void testGetAllMoviesOrderByPriceDESC() {
        List<Movie> allMoviesSortedByPriceDesc = movieRep.getAllMoviesSortedByPriceDESC();
        for (int i = 0; i < allMoviesSortedByPriceDesc.size() - 1; i++) {
            Movie thisMovie = allMoviesSortedByPriceDesc.get(i);
            Movie nextMovie = allMoviesSortedByPriceDesc.get(i + 1);
            assertTrue(thisMovie.getPrice() >= nextMovie.getPrice());
        }
    }

    @Test
    void testGetAllMoviesOrderByPriceASC() {
        List<Movie> allMoviesSortedByPriceAsc = movieRep.getAllMoviesSortedByPriceASC();
        for (int i = 0; i < allMoviesSortedByPriceAsc.size() - 1; i++) {
            Movie thisMovie = allMoviesSortedByPriceAsc.get(i);
            Movie nextMovie = allMoviesSortedByPriceAsc.get(i + 1);
            assertTrue(thisMovie.getPrice() <= nextMovie.getPrice());
        }
    }

    @Test
    void testGetAllMoviesByGenreOrderByPriceDESC() {
        List<Movie> moviesByGenreSortedByPriceDesc = movieRep.getMoviesByGenreIdSortedByPriceDESC(1L);
        for (int i = 0; i < moviesByGenreSortedByPriceDesc.size() - 1; i++) {
            Movie thisMovie = moviesByGenreSortedByPriceDesc.get(i);
            Movie nextMovie = moviesByGenreSortedByPriceDesc.get(i + 1);
            assertTrue(thisMovie.getPrice() >= nextMovie.getPrice());
        }
    }

    @Test
    void testGetAllMoviesByGenreOrderByPriceASC() {
        List<Movie> moviesByGenreSortedByPriceAsc = movieRep.getMoviesByGenreIdSortedByPriceASC(1L);
        for (int i = 0; i < moviesByGenreSortedByPriceAsc.size() - 1; i++) {
            Movie thisMovie = moviesByGenreSortedByPriceAsc.get(i);
            Movie nextMovie = moviesByGenreSortedByPriceAsc.get(i + 1);
            assertTrue(thisMovie.getPrice() <= nextMovie.getPrice());
        }
    }

    @Test
    void testGetMovieExtendedInfoById(){
        Set<Review> reviewsSet = new HashSet<>();
        Set<Genre> genresSet = new HashSet<>();
        Set<Country> countriesSet = new HashSet<>();
        countriesSet.add(new Country(1L, "США"));
        genresSet.add(new Genre(1L, "драма"));
        genresSet.add(new Genre(2L, "криминал"));
        reviewsSet.add(Review.builder()
                .id(1L)
                .user(User.builder()
                        .id(2L)
                        .nickname("Дарлин Эдвардс")
                        .build())
                .text("Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.")
                .build());

        reviewsSet.add(Review.builder()
                .id(2L)
                .user(User.builder()
                        .id(3L)
                        .nickname("Габриэль Джексон")
                        .build())
                .text("Кино это является, безусловно, «со знаком качества». Что же до первого места в рейтинге, то, думаю, здесь имело место быть выставление «десяточек» от большинства зрителей вкупе с раздутыми восторженными откликами кинокритиков. Фильм атмосферный. Он драматичный. И, конечно, заслуживает того, чтобы находиться довольно высоко в мировом кинематографе.")
                .build());

        MovieExtendedInformation movieExpected = MovieExtendedInformation.builder()
                .id(1L)
                .nameRussian("Побег из Шоушенка")
                .nameNative("The Shawshank Redemption")
                .yearOfRelease(1994)
                .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")
                .description("Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.")
                .rating(8.9)
                .price(123.45)
                .countries(countriesSet)
                .genres(genresSet)
                .reviews(reviewsSet)
                .build();

        MovieExtendedInformation movieActual = movieRep.getMovieById(1L);


        assertEquals(movieExpected, movieActual);
    }
}