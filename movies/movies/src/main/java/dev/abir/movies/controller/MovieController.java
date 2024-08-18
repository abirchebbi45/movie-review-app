package dev.abir.movies.controller;

import dev.abir.movies.entity.Movie;
import dev.abir.movies.repository.ReviewRepository;
import dev.abir.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



// Annotation définissant que cette classe est un contrôleur REST
@RestController
// Mappage de l'URI de base pour toutes les requêtes associées aux films
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    // Injection de dépendance du service MovieService
    @Autowired
    private MovieService movieService;

    private ReviewRepository reviewRepository;

    // Point de terminaison pour obtenir tous les films
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        // Renvoie la liste de tous les films avec un code de statut HTTP OK
        return new ResponseEntity<List<Movie>>(movieService.findAllMovies(), HttpStatus.OK);
    }

    // Point de terminaison pour obtenir un seul film par son identifiant IMDb
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        // Renvoie un film unique avec un code de statut HTTP OK
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
}


