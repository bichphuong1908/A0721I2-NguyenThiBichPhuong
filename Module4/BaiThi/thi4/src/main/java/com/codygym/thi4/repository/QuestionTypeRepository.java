package com.codygym.thi4.repository;

import com.codygym.thi4.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {

}
