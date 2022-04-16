package com.codegym.thuchanh.service.ipml;

import com.codegym.thuchanh.model.QuestionType;
import com.codegym.thuchanh.repository.QuestionTypeRepository;
import com.codegym.thuchanh.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<QuestionType> findById(Long id) {
        return questionTypeRepository.findById(id);
    }
}
