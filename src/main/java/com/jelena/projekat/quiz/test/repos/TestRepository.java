package com.jelena.projekat.quiz.test.repos;

import com.jelena.projekat.quiz.test.entities.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TestRepository extends MongoRepository<Test, String> {

    @Query("{ 'author' : ?0 }")
    List<Test> findAllByAuthor(String email);

    @Query("{ 'level' : ?0 , 'category' : ?1 }")
    List<Test> findAllByLevelAndCategory(String level, String category);
}
