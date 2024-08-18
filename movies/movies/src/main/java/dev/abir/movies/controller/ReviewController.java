package dev.abir.movies.controller;

import dev.abir.movies.entity.Review;
import dev.abir.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// Contrôleur REST pour les critiques
@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    // Injection de dépendance du service ReviewService
    @Autowired
    private ReviewService reviewService;

    // Point de terminaison pour créer une critique
    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        // Crée une critique et la renvoie avec un code de statut HTTP OK
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }



}
