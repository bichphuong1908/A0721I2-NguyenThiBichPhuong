package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
