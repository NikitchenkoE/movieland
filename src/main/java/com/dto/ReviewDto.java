package com.dto;

import com.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDto {
    private Long id;
    private UserDto userDto;
    private String text;
}
