package com.model.impl;

import com.dto.ReviewDtoWithoutUser;
import com.entity.User;
import com.model.ReviewService;
import com.model.mapper.ReviewMapper;
import com.repository.ReviewRepository;
import com.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public void addReview(ReviewDtoWithoutUser reviewDtoWithoutUser,
                          String userEmail) {
        User user = userRepository.getByEmail(userEmail);
        reviewDtoWithoutUser.setUser(user);
        reviewRepository.save(reviewMapper.mapToReview(reviewDtoWithoutUser));
    }
}
