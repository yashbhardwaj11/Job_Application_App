package com.embarkx.reviewsms.reviews.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.embarkx.reviewsms.reviews.Reviews;
import com.embarkx.reviewsms.reviews.ReviewsRepository;
import com.embarkx.reviewsms.reviews.ReviewsService;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public String addReview(Long companyId, Reviews review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewsRepository.save(review);
            return "Review added";
        } else {
            return "Not Found";
        }
    }

    @Override
    public Reviews getReviewById(Long reviewId) {
        return reviewsRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReviewById(Long reviewId, Reviews updatedReview) {
        Reviews existingReview = reviewsRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            if (updatedReview.getTitle() != null && !updatedReview.getTitle().isEmpty())
                existingReview.setTitle(updatedReview.getTitle());
            if (updatedReview.getDescription() != null && !updatedReview.getDescription().isEmpty())
                existingReview.setDescription(updatedReview.getDescription());
            if (updatedReview.getRating() >= 0)
                existingReview.setRating(updatedReview.getRating());
            if (updatedReview.getCompanyId() != null)
                existingReview.setRating(updatedReview.getCompanyId());
            reviewsRepository.save(existingReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        if (reviewId != null) {
            Reviews existingReview = reviewsRepository.findById(reviewId).orElse(null);
            if (existingReview != null) {
                reviewsRepository.deleteById(reviewId);
                return true;
            }
        }
        return false;
    }

}
