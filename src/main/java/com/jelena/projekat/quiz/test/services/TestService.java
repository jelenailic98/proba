package com.jelena.projekat.quiz.test.services;

import com.jelena.projekat.quiz.test.dto.TestDTO;
import com.jelena.projekat.quiz.test.entities.Test;
import com.jelena.projekat.quiz.test.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestRepository repo;

    public List<Test> getTestByAuthor(String email) {
        return repo.findAllByAuthor(email);
    }

    public Test getTestById(String id) {
        return repo.findById(id).orElse(new Test());
    }

    public Test setPassScore(String id, Integer newPassScore) {
        Test test = repo.findById(id).orElse(null);
        if(test==null)
            return null;
        test.setPassScore(newPassScore);
        repo.save(test);
        return test;
    }

    public Test createTest(Test test) {
        repo.save(test);
        return test;
    }

    public Test getTestByLevelAndCategory(String level, String category) {
        List<Test> tests = repo.findAllByLevelAndCategory(level, category);
        if(tests.isEmpty())
            return null;
        return tests.get(0);
    }
}
