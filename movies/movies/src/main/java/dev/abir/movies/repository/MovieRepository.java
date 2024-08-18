package dev.abir.movies.repository;

import dev.abir.movies.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Annotation définissant que cette interface est un repository Spring Data pour les films
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    // Méthode pour trouver un film par son identifiant IMDb
    Optional<Movie> findMovieByImdbId(String imdbId);
}
