package com.jelena.projekat.quiz.test.dto;

import com.jelena.projekat.quiz.test.entities.Answer;

import java.util.List;

public class QuestionDTO {

    private String id;
    private String text;
    private String type;
    private List<AnswerDTO> answers;
    private String correctMessage;
    private String failMessage;
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public String getCorrectMessage() {
        return correctMessage;
    }

    public void setCorrectMessage(String correctMessage) {
        this.correctMessage = correctMessage;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
