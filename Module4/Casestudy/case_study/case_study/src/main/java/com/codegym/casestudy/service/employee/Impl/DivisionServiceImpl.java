package com.codegym.casestudy.service.employee.Impl;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.repository.employee.DivisionRepository;
import com.codegym.casestudy.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void delete(Long id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }
}
