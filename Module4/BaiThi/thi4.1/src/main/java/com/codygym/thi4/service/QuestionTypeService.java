package com.codygym.thi4.service;

import com.codygym.thi4.model.QuestionType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QuestionTypeService {
    List<QuestionType> findAll();
    void save(QuestionType questionType);
    void delete(Long id);
    QuestionType findById(Long id);
}
