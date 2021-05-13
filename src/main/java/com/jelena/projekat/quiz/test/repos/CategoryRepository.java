package com.jelena.projekat.quiz.test.repos;

import com.jelena.projekat.quiz.test.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
