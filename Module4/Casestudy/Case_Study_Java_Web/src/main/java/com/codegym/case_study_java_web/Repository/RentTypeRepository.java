package com.codegym.case_study_java_web.Repository;


import com.codegym.case_study_java_web.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
