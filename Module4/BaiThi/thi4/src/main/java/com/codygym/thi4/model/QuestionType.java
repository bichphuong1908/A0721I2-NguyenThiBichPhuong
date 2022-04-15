package com.codygym.thi4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "questionType")
    private Set<Question> questions;

    public QuestionType() {
    }

    public QuestionType(long id, String name, Set<Question> questions) {
        this.id = id;
        this.name = name;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
