package com.codygym.thi4.model;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String question;
    private String answer;
    private String dateCreate;
    private String status;

//    (targetEntity = QuestionType.class)
    @ManyToOne
    @JoinColumn(name = "questions")
    private QuestionType questionType;

    public Question() {
    }

    public Question(long id, String title, String question, String answer, String dateCreate, String status, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.dateCreate = dateCreate;
        this.status = status;
        this.questionType = questionType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
