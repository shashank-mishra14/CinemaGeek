package com.movieSystem.CinemaGeek.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.movieSystem.CinemaGeek.service.ReviewService;
import com.movieSystem.CinemaGeek.model.Review;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController{
    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
}