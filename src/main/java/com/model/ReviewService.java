package com.model;

import com.dto.ReviewDtoWithoutUser;

public interface ReviewService {
    void addReview(ReviewDtoWithoutUser reviewDtoWithoutUser,
                   String userEmail);
}
