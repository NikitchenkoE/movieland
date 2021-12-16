package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieRequestData {
    private String ratingRequestInfo;
    private String priceRequestInfo;
    private Long genreId;
    private int countOfRandomMovies;
    private Long movieId;
    private String currencyInfo;
}
