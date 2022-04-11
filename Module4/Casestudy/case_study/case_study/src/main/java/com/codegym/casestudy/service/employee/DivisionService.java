package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Division;

import java.util.List;


public interface DivisionService {
    List<Division> findAll();

    void save(Division division);

    void delete(Long id);

    Division findById(Long id);
}
