package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private Long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String country;
    private String picturePath;
    private String description;
    private double rating;
    private double price;
}
