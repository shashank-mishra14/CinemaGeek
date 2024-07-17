package com.movieSystem.CinemaGeek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import com.movieSystem.CinemaGeek.repository.ReviewRepository;
import com.movieSystem.CinemaGeek.model.Review;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
        .matching(Criteria.where("imdbId").is(imdbId))
        .apply(new Update().push("reviewIds").value(review.getId()))
        .first();
    
        return review;
    }
}