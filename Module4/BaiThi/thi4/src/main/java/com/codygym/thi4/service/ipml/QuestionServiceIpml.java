package com.codygym.thi4.service.ipml;

import com.codygym.thi4.model.Question;
import com.codygym.thi4.repository.QuestionRepository;
import com.codygym.thi4.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceIpml implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public List<Question> findAll() {
        return (List<Question>) questionRepository.findAll();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findAllByTitleContaining(String name, Pageable pageable) {
        return questionRepository.findAllByTitleContaining(name, pageable);
    }
}
