package com.jelena.projekat.quiz.test.dto;

import java.util.List;

public class CategoryDTO {

    private String id;
    private String name;
    private List<String> testIds;

    public List<String> getTestIds() {
        return testIds;
    }

    public void setTestIds(List<String> testIds) {
        this.testIds = testIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
