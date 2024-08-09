package com.embarkx.reviewsms.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Long>{

    List<Reviews> findByCompanyId(Long companyId);

    
}