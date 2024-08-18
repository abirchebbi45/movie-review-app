package dev.abir.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// Annotation définissant que cette classe est mappée sur une collection MongoDB nommée "movies"
@Document(collection = "movies")
// Annotations Lombok pour la génération automatique des constructeurs et des méthodes getter/setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    // Annotation définissant que cet attribut est l'identifiant de document MongoDB
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    // Annotation définissant une référence à une autre collection MongoDB pour les avis
    @DocumentReference
    private List<Review> reviews;
    //private List<Review> reviewIds;


    // Constructeur
    public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster, List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
    }
}
