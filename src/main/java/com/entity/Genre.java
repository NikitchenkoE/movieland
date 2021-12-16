package com.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Genre {
    private Long id;
    private String name;
}
