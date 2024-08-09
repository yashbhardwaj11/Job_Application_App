package com.embarkx.reviewsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ReviewsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsmsApplication.class, args);
	}

}
