package com.web.controller;

import com.dto.ReviewDtoWithoutUser;
import com.model.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class ReviewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void shouldCreateReview() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders
                .post("/api/v1/review")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"movieId\" : 1, \"text\" : \"Очень понравилось, очень интересно!\"}"))
                .andExpect(status().isOk());

        Mockito.verify(reviewService).addReview(Mockito.any(ReviewDtoWithoutUser.class), Mockito.any(String.class));
    }

}