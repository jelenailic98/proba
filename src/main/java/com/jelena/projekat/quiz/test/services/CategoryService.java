package com.jelena.projekat.quiz.test.services;

import com.jelena.projekat.quiz.test.entities.Category;
import com.jelena.projekat.quiz.test.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}
