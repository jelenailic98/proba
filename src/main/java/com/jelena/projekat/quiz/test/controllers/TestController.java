package com.jelena.projekat.quiz.test.controllers;

import com.jelena.projekat.quiz.test.dto.TestDTO;
import com.jelena.projekat.quiz.test.entities.Test;
import com.jelena.projekat.quiz.test.services.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    TestService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/email/{email}")
    public TestDTO getTestByAuthor(@PathVariable String email) {
        return modelMapper.map(service.getTestByAuthor(email), TestDTO.class);
    }

    @GetMapping(value = "/id/{id}")
    public TestDTO getTestById(@PathVariable String id) {
        return modelMapper.map(service.getTestById(id), TestDTO.class);
    }

    //obrati paznju da li ovo radi
    @GetMapping(value = "/levelandcategory/{level}/{category}")
    public TestDTO getTestByLevelAndCategory(@PathVariable String level, @PathVariable String category) {
        return modelMapper.map(service.getTestByLevelAndCategory(level, category), TestDTO.class);
    }

    @PatchMapping(value = "/setPassScore/{id}/{newPassScore}")
    public TestDTO setPassScore(@PathVariable String id, @PathVariable Integer newPassScore) {
        return modelMapper.map(service.setPassScore(id, newPassScore), TestDTO.class);
    }

    @PostMapping(value = "/createTest")
    public void createTest(@RequestBody TestDTO test) {
        service.createTest(modelMapper.map(test, Test.class));
    }
}
