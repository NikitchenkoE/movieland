package com.web.controller;

import com.dto.MovieAddDto;
import com.dto.MovieDto;
import com.dto.MovieRequestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MoviesControllerITest {
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MovieDto movieDto1 = MovieDto.builder()
            .id(1L)
            .nameRussian("Побег из Шоушенка")
            .nameNative("The Shawshank Redemption")
            .yearOfRelease(1994)
            .rating(8.90)
            .price(123.45)
            .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")
            .build();
    private final MovieDto movieDto2 = MovieDto.builder()
            .id(2L)
            .nameRussian("Зеленая миля")
            .nameNative("The Green Mile")
            .yearOfRelease(1999)
            .rating(8.90)
            .price(134.67)
            .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg")
            .build();
    private final MovieDto movieDto3 = MovieDto.builder()
            .id(3L)
            .nameRussian("Танцующий с волками")
            .nameNative("Dances with Wolves")
            .yearOfRelease(1990)
            .rating(8.00)
            .price(120.55)
            .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg")
            .build();
    private final List<MovieDto> movieDtos = Arrays.asList(movieDto1, movieDto2, movieDto3);

    @MockBean
    private MovieService movieService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findAllServiceShouldGiveRightInformationAndControllerShouldReturnRightJson() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].nameRussian", is("Побег из Шоушенка")))
                .andExpect(jsonPath("$[1].nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("$[2].nameRussian", is("Танцующий с волками")))
                .andExpect(jsonPath("$[0].nameNative", is("The Shawshank Redemption")))
                .andExpect(jsonPath("$[1].nameNative", is("The Green Mile")))
                .andExpect(jsonPath("$[2].nameNative", is("Dances with Wolves")))
                .andExpect(jsonPath("$[0].yearOfRelease", is(1994)))
                .andExpect(jsonPath("$[1].yearOfRelease", is(1999)))
                .andExpect(jsonPath("$[2].yearOfRelease", is(1990)))
                .andExpect(jsonPath("$[0].rating", is(8.90)))
                .andExpect(jsonPath("$[1].rating", is(8.90)))
                .andExpect(jsonPath("$[2].rating", is(8.00)))
                .andExpect(jsonPath("$[0].price", is(123.45)))
                .andExpect(jsonPath("$[1].price", is(134.67)))
                .andExpect(jsonPath("$[2].price", is(120.55)))
                .andExpect(jsonPath("$[0].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void findRandomNumberServiceShouldGiveRightInformationAndControllerShouldReturnRightJson() throws Exception {
        Mockito.when(movieService.getRandomMovies(MovieRequestData.builder().countOfRandomMovies(3).build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testgetMoviesByGenreIdShouldReturnMoviesDtoInJsonFormat() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].nameRussian", is("Побег из Шоушенка")))
                .andExpect(jsonPath("$[1].nameRussian", is("Зеленая миля")))
                .andExpect(jsonPath("$[2].nameRussian", is("Танцующий с волками")))
                .andExpect(jsonPath("$[0].nameNative", is("The Shawshank Redemption")))
                .andExpect(jsonPath("$[1].nameNative", is("The Green Mile")))
                .andExpect(jsonPath("$[2].nameNative", is("Dances with Wolves")))
                .andExpect(jsonPath("$[0].yearOfRelease", is(1994)))
                .andExpect(jsonPath("$[1].yearOfRelease", is(1999)))
                .andExpect(jsonPath("$[2].yearOfRelease", is(1990)))
                .andExpect(jsonPath("$[0].rating", is(8.90)))
                .andExpect(jsonPath("$[1].rating", is(8.90)))
                .andExpect(jsonPath("$[2].rating", is(8.00)))
                .andExpect(jsonPath("$[0].price", is(123.45)))
                .andExpect(jsonPath("$[1].price", is(134.67)))
                .andExpect(jsonPath("$[2].price", is(120.55)))
                .andExpect(jsonPath("$[0].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[1].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg")))
                .andExpect(jsonPath("$[2].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg")));
    }

    @Test
    public void testGetAllMoviesSortedByRating() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().ratingRequestInfo("desc").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetAllMoviesSortedByRatingCapital() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().ratingRequestInfo("DESC").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie?rating=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByRating() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).ratingRequestInfo("desc").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByCapital() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).ratingRequestInfo("DESC").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1?rating=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceDesc() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().priceRequestInfo("desc").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceDescCapital() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().priceRequestInfo("DESC").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie?price=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceAsc() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().priceRequestInfo("asc").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetAllMoviesSortedByPriceAscCapital() throws Exception {
        Mockito.when(movieService.getAllMovies(MovieRequestData.builder().priceRequestInfo("ASC").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie?price=ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceDesc() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).priceRequestInfo("desc").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceDescCapital() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).priceRequestInfo("DESC").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1?price=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceAscCapital() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).priceRequestInfo("ASC").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1?price=ASC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void testGetMoviesByGenreIdSortedByPriceAsc() throws Exception {
        Mockito.when(movieService.getMoviesByGenreId(MovieRequestData.builder().genreId(1L).priceRequestInfo("asc").build()))
                .thenReturn(movieDtos);
        mockMvc.perform(get("/api/v1/movie/genre/1?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void testAddMovieShouldAddMovie() throws Exception {
        Set<Long> countriesAndGenresId = new HashSet<>();
        countriesAndGenresId.add(1L);
        countriesAndGenresId.add(2L);
        MovieAddDto movie = MovieAddDto.builder()
                .id(1L)
                .nameRussian("Руский")
                .nameNative("Native")
                .price(125.5)
                .description("description")
                .picturePath("path")
                .yearOfRelease(2222)
                .countries(countriesAndGenresId)
                .genres(countriesAndGenresId)
                .build();

        mockMvc.perform(post("/api/v1/movie")
                .content(objectMapper.writeValueAsString(movie))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(movieService).addMovie(Mockito.any(MovieAddDto.class));
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void testAddMovieShouldRestrict() {
        Set<Long> countriesAndGenresId = new HashSet<>();
        countriesAndGenresId.add(1L);
        countriesAndGenresId.add(2L);
        MovieAddDto movie = MovieAddDto.builder()
                .id(1L)
                .nameRussian("Руский")
                .nameNative("Native")
                .price(125.5)
                .description("description")
                .picturePath("path")
                .yearOfRelease(2222)
                .countries(countriesAndGenresId)
                .genres(countriesAndGenresId)
                .build();

        NestedServletException ex = assertThrows(NestedServletException.class, () ->
                mockMvc.perform(post("/api/v1/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movie))));

        assertTrue(ex.getCause() instanceof org.springframework.security.access.AccessDeniedException);

    }

}