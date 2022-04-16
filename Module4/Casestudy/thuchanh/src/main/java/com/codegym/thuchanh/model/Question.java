package com.codegym.thuchanh.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String question;
    private String answer;
    private LocalDate dateCreat;

    @ManyToOne
    @JoinColumn(name = "questions")
    private QuestionType questionType;

    public Question() {
    }

    public Question(long id, String title, String question, String answer, LocalDate dateCreat, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.answer = answer;
        this.dateCreat = dateCreat;
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

    public LocalDate getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(LocalDate dateCreat) {
        this.dateCreat = dateCreat;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
