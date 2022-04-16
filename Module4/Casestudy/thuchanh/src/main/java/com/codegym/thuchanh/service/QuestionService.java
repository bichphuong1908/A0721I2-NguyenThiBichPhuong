package com.codegym.thuchanh.service;

import com.codegym.thuchanh.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> findAll();
    void save(Question question);
    void delete(Long id);
    Optional<Question> findById(Long id);
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAllByTitleContaining(String title, Pageable pageable);
}
