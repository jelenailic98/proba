package com.jelena.projekat.quiz.test.controllers;

import com.jelena.projekat.quiz.test.dto.CategoryDTO;
import com.jelena.projekat.quiz.test.entities.Category;
import com.jelena.projekat.quiz.test.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/all")
    public List<Category> getAllCategories() {
        List<Category> categories = service.getAllCategories();
        List<CategoryDTO> categoriesDTO= new ArrayList<>();
        for (Category c: categories) {
            categoriesDTO.add(modelMapper.map(c, CategoryDTO.class));
        }

        return categories;
    }
}
