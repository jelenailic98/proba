package com.jelena.projekat.quiz.test.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.jelena.projekat.quiz.test.dto.TestDTO;
import com.jelena.projekat.quiz.test.entities.Test;
import com.jelena.projekat.quiz.test.services.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Mutation implements GraphQLMutationResolver {

    private TestService service;

    @Autowired
    private ModelMapper modelMapper;

    public Mutation(TestService service) {
        this.service = service;
    }

    public TestDTO setPassScore(String id, Integer newPassScore) {
        return modelMapper.map(service.setPassScore(id, newPassScore), TestDTO.class);
    }

    public TestDTO createTest(TestDTO test) {

        Test newTest= service.createTest(modelMapper.map(test, Test.class));
        return modelMapper.map(test, TestDTO.class);
    }
}
