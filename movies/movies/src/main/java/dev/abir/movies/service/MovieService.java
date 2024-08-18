package dev.abir.movies.service;

import dev.abir.movies.entity.Movie;
import dev.abir.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Annotation définissant que cette classe est un service
@Service
public class MovieService {

    // Injection de dépendance du repository MovieRepository
    @Autowired
    private MovieRepository movieRepository;

    // Méthode pour récupérer tous les films
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    // Méthode pour récupérer un film par son identifiant IMDb
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
