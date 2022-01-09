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
public class MovieAddDto {
    private Long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String description;
    private double price;
    private String picturePath;
    private Set<Long> countries;
    private Set<Long> genres;
}
