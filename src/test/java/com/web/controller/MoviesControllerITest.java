package com.web.controller;

import com.config.SpringTestContext;
import com.config.WebConfig;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, SpringTestContext.class})
class MoviesControllerITest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findAllServiceShouldGiveRightInformationAndControllerShouldReturnRightJson() throws Exception {
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
        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testgetMoviesByGenreIdShouldReturnMoviesDtoInJsonFormat() throws Exception {
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

    @Test
    public void testGetAllMoviesSortedByRating() throws Exception {
        mockMvc.perform(get("/movie?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)));
    }

    @Test
    public void testGetAllMoviesSortedByRatingCapital() throws Exception {
        mockMvc.perform(get("/movie?rating=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByRating() throws Exception {
        mockMvc.perform(get("/movie/genre/1?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByCapital() throws Exception {
        mockMvc.perform(get("/movie/genre/1?rating=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceDesc() throws Exception {
        mockMvc.perform(get("/movie?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceDescCapital() throws Exception {
        mockMvc.perform(get("/movie?price=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceAsc() throws Exception {
        mockMvc.perform(get("/movie?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceAscCapital() throws Exception {
        mockMvc.perform(get("/movie?price=ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(25)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceDesc() throws Exception {
        mockMvc.perform(get("/movie/genre/1?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceDescCapital() throws Exception {
        mockMvc.perform(get("/movie/genre/1?price=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceAscCapital() throws Exception {
        mockMvc.perform(get("/movie/genre/1?price=ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceAsc() throws Exception {
        mockMvc.perform(get("/movie/genre/1?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(16)));
    }

}