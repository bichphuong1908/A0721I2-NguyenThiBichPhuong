package com.codygym.thi4.service.ipml;

import com.codygym.thi4.model.QuestionType;
import com.codygym.thi4.repository.QuestionTypeRepository;
import com.codygym.thi4.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceIpml implements QuestionTypeService {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public QuestionType findById(Long id) {
        return null;
    }
}
