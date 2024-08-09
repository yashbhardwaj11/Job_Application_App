package com.embarkx.reviewsms.reviews;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    private ReviewsService reviewsService;
    public ReviewsController(ReviewsService reviewsService){
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews(@RequestParam Long companyId) {
        return ResponseEntity.ok(reviewsService.getAllReviews(companyId));
    }
    
    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long companyId ,@RequestBody Reviews reviews) {
        return ResponseEntity.ok(reviewsService.addReview(companyId , reviews));
    }
    
    @GetMapping("/{reviewId}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long reviewId) {
        Reviews review = reviewsService.getReviewById(reviewId);
        if(review != null){
            return ResponseEntity.ok(review);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long reviewId , @RequestBody Reviews reviews) {
        boolean isUpdated = reviewsService.updateReviewById(reviewId,reviews);
        if (isUpdated) {
            return ResponseEntity.ok("Review updated successfully");
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long reviewId ) {
        boolean isDeleted = reviewsService.deleteReviewById(reviewId);
        if(isDeleted){
            return ResponseEntity.ok("Review deleted Successfull");
        }else{
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }
    
    
    
}
