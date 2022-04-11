package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    void save(Position position);

    void delete(Long id);

    Position findById(Long id);
}
