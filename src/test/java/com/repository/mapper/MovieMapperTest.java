package com.repository.mapper;

import com.entity.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieMapperTest {

    @Mock
    ResultSet resultSetMock;

    MockitoSession mockitoSession;
    MovieMapper movieMapper = new MovieMapper();

    @BeforeEach
    void before() {
        mockitoSession = Mockito.mockitoSession().initMocks(this).startMocking();
    }

    @AfterEach
    void after() {
        mockitoSession.finishMocking();
    }

    @Test
    void mapRowTest() throws SQLException {
        Mockito.when(resultSetMock.getLong("movieID")).thenReturn(1L);
        Mockito.when(resultSetMock.getString("nameRussian")).thenReturn("movieNameRussian");
        Mockito.when(resultSetMock.getString("nameNative")).thenReturn("movieNameNative");
        Mockito.when(resultSetMock.getInt("yearOfRelease")).thenReturn(2011);
        Mockito.when(resultSetMock.getString("country")).thenReturn("Ukraine");
        Mockito.when(resultSetMock.getString("picturePath")).thenReturn("imagePath");
        Mockito.when(resultSetMock.getDouble("rating")).thenReturn(10.0);
        Mockito.when(resultSetMock.getDouble("price")).thenReturn(15.00);

        Movie movieExpected = Movie.builder().
                id(1L)
                .nameRussian("movieNameRussian")
                .nameNative("movieNameNative")
                .yearOfRelease(2011)
                .country("Ukraine")
                .picturePath("imagePath")
                .rating(10.0)
                .price(15.00)
                .build();

        Movie movieActual = movieMapper.mapRow(resultSetMock, 10);
        assertEquals(movieExpected, movieActual);
    }
}