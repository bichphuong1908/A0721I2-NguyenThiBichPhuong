package com.codegym.casestudy.service.employee.Impl;

import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.repository.employee.PositionRepository;
import com.codegym.casestudy.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void delete(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Position findById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }
}
