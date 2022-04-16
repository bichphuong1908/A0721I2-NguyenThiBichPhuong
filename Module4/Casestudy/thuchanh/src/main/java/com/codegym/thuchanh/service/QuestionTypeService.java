package com.codegym.thuchanh.service;

import com.codegym.thuchanh.model.QuestionType;

import java.util.List;
import java.util.Optional;

public interface QuestionTypeService {
    List<QuestionType> findAll();
    void save(QuestionType questionType);
    void delete(Long id);
    Optional<QuestionType> findById(Long id);
}
