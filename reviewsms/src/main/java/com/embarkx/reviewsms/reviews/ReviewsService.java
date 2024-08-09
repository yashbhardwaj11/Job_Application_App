package com.embarkx.reviewsms.reviews;

import java.util.List;


public interface ReviewsService {

    List<Reviews> getAllReviews(Long companyId);
    String addReview(Long companyId, Reviews reviews);
    Reviews getReviewById(Long reviewId);
    boolean updateReviewById(Long reviewId, Reviews reviews);
    boolean deleteReviewById(Long reviewId);
    
}
