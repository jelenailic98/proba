package com.jelena.projekat.quiz.test;

import com.jelena.projekat.quiz.test.resolvers.Mutation;
import com.jelena.projekat.quiz.test.resolvers.Query;
import com.jelena.projekat.quiz.test.services.CategoryService;
import com.jelena.projekat.quiz.test.services.TestService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public Query query(TestService testService, CategoryService categoryService) {
		return new Query(testService, categoryService);
	}

	@Bean
	public Mutation mutation(TestService service) {
		return new Mutation(service);
	}

}
