package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);

    void delete(Long id);

    EducationDegree findById(Long id);
}
