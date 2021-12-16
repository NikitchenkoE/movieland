package com.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class GenreDto {
    private Long id;
    private String name;
}
