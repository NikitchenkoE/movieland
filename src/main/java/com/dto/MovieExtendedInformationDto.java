package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieExtendedInformationDto {
    private Long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String picturePath;
    private String description;
    private double rating;
    private double price;
    private Set<CountryDto> countriesSet;
    private Set<GenreDto> genresSet;
    private Set<ReviewDto> reviewsSet;
}
