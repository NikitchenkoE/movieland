package com.entity;

import lombok.*;

import java.util.List;

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
    private List<String> genres;
    private String description;
    private String picturePath;
    private double rating;
    private double price;
}
