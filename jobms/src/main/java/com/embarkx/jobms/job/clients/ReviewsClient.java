package com.embarkx.jobms.job.clients;

import com.embarkx.jobms.job.external.Reviews;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "REVIEWS-SERVICE")
public interface ReviewsClient {
    @GetMapping("/reviews")
    ResponseEntity<List<Reviews>> getReviews(@RequestParam("companyId") Long companyId);
}
