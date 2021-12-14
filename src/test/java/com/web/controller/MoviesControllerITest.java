package com.web.controller;

import com.config.WebConfig;
import com.config.RootConfig;
import com.dto.MovieDto;
import com.model.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
class MoviesControllerITest {
    private MockMvc mockMvc;
    private final MovieService movieService = mock(MovieService.class);

    @Autowired
    private WebApplicationContext webApplicationContext;

    MovieDto movieDto = MovieDto.builder()
            .id(1L)
            .nameRussian("Руский")
            .nameNative("Native")
            .yearOfRelease(1000)
            .price(100.00)
            .rating(10.00)
            .picturePath("path")
            .build();

    MovieDto movieDto2 = MovieDto.builder()
            .id(1L)
            .nameRussian("Руский2")
            .nameNative("Native2")
            .yearOfRelease(100)
            .price(12.00)
            .rating(8.00)
            .picturePath("path2")
            .build();

    List<MovieDto> movies = Arrays.asList(movieDto, movieDto2);

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findAllServiceShouldGiveRightInformationAndControllerShouldReturnRightJson() throws Exception {
        when(movieService.getAllMovies()).thenReturn(movies);
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[24].id", is(25)))
                .andExpect(jsonPath("$[0].nameRussian", is("Побег из Шоушенка")))
                .andExpect(jsonPath("$[1].nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("$[24].nameRussian", is("Танцующий с волками")))
                .andExpect(jsonPath("$[0].nameNative", is("The Shawshank Redemption")))
                .andExpect(jsonPath("$[1].nameNative", is("The Green Mile")))
                .andExpect(jsonPath("$[24].nameNative", is("Dances with Wolves")))
                .andExpect(jsonPath("$[0].yearOfRelease", is(1994)))
                .andExpect(jsonPath("$[1].yearOfRelease", is(1999)))
                .andExpect(jsonPath("$[24].yearOfRelease", is(1990)))
                .andExpect(jsonPath("$[0].rating", is(8.90)))
                .andExpect(jsonPath("$[1].rating", is(8.90)))
                .andExpect(jsonPath("$[24].rating", is(8.00)))
                .andExpect(jsonPath("$[0].price", is(123.45)))
                .andExpect(jsonPath("$[1].price", is(134.67)))
                .andExpect(jsonPath("$[24].price", is(120.55)))
                .andExpect(jsonPath("$[0].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[24].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void findRandomNumberServiceShouldGiveRightInformationAndControllerShouldReturnRightJson() throws Exception {
        when(movieService.getAllMovies()).thenReturn(movies);
        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testgetMoviesByGenreIdShouldReturnMoviesDtoInJsonFormat() throws Exception {
        when(movieService.getAllMovies()).thenReturn(movies);
        mockMvc.perform(get("/movie/genre/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[15].id", is(25)))
                .andExpect(jsonPath("$[0].nameRussian", is("Побег из Шоушенка")))
                .andExpect(jsonPath("$[1].nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("$[15].nameRussian", is("Танцующий с волками")))
                .andExpect(jsonPath("$[0].nameNative", is("The Shawshank Redemption")))
                .andExpect(jsonPath("$[1].nameNative", is("The Green Mile")))
                .andExpect(jsonPath("$[15].nameNative", is("Dances with Wolves")))
                .andExpect(jsonPath("$[0].yearOfRelease", is(1994)))
                .andExpect(jsonPath("$[1].yearOfRelease", is(1999)))
                .andExpect(jsonPath("$[15].yearOfRelease", is(1990)))
                .andExpect(jsonPath("$[0].rating", is(8.90)))
                .andExpect(jsonPath("$[1].rating", is(8.90)))
                .andExpect(jsonPath("$[15].rating", is(8.00)))
                .andExpect(jsonPath("$[0].price", is(123.45)))
                .andExpect(jsonPath("$[1].price", is(134.67)))
                .andExpect(jsonPath("$[15].price", is(120.55)))
                .andExpect(jsonPath("$[0].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[15].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg")));
    }
}