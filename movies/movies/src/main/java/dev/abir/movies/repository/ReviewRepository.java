package dev.abir.movies.repository;

import dev.abir.movies.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Repository Spring Data pour les critiques
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
