package com.web.controller;

import com.dto.ReviewDtoWithoutUser;
import com.model.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/review")
    public void addReview(@RequestBody ReviewDtoWithoutUser review,
                          Principal principal) {
        reviewService.addReview(review, principal.getName());
    }
}
