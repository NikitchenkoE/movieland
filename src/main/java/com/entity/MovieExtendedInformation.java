package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieExtendedInformation {
    private Long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String picturePath;
    private String description;
    private double rating;
    private double price;
    private Set<Country> countries;
    private Set<Genre> genres;
    private Set<Review> reviews;
}
