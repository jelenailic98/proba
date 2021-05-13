package com.jelena.projekat.quiz.test.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.jelena.projekat.quiz.test.dto.CategoryDTO;
import com.jelena.projekat.quiz.test.dto.TestDTO;
import com.jelena.projekat.quiz.test.entities.Category;
import com.jelena.projekat.quiz.test.entities.Test;
import com.jelena.projekat.quiz.test.services.CategoryService;
import com.jelena.projekat.quiz.test.services.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class Query implements GraphQLQueryResolver {

    private TestService testService;
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    public Query(TestService testService, CategoryService categoryService) {
        this.testService = testService;
        this.categoryService = categoryService;
    }

    public List<TestDTO> findAllTestsByAuthor(String email) {
        List<Test> tests = testService.getTestByAuthor(email);
        List<TestDTO> testsDTO = new ArrayList<>();
        for (Test t: tests) {
            testsDTO.add(modelMapper.map(t, TestDTO.class));
        }

        return testsDTO;
    }

    public TestDTO findTestById( String id) {
        return modelMapper.map(testService.getTestById(id), TestDTO.class);
    }

    public TestDTO findTestByLevelAndCategory(String level, String category) {
        return modelMapper.map(testService.getTestByLevelAndCategory(level, category), TestDTO.class);
    }

    public List<CategoryDTO> findAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryDTO> categoriesDTO= new ArrayList<>();
        for (Category c: categories) {
            categoriesDTO.add(modelMapper.map(c, CategoryDTO.class));
        }

        return categoriesDTO;
    }
}
