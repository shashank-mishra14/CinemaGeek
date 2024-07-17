package com.movieSystem.CinemaGeek.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.movieSystem.CinemaGeek.model.Review;
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}