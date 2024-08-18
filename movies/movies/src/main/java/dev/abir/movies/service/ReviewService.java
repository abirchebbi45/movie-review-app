package dev.abir.movies.service;

import dev.abir.movies.entity.Movie;
import dev.abir.movies.entity.Review;
import dev.abir.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// Service pour gérer les critiques
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));



        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                //.apply(new Update().push("reviewIds").value(review))
                .apply(new Update().push("reviewIds").value(review.getId()))
                .first();
        return review;
    }



}

