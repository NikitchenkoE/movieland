package com.entity.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDto {
    private Long id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String picturePath;
    private double rating;
    private double price;
}
