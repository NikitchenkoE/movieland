package com.model.mapper;

import com.dto.ReviewDtoWithoutUser;
import com.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review mapToReview(ReviewDtoWithoutUser reviewDto);
}
