package com.codygym.thi4.repository;

import com.codygym.thi4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAllByTitleContaining(String name, Pageable pageable);
}
