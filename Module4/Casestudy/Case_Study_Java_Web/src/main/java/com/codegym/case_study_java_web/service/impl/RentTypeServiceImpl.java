package com.codegym.case_study_java_web.service.impl;

import com.codegym.case_study_java_web.Repository.RentTypeRepository;
import com.codegym.case_study_java_web.model.RentType;
import com.codegym.case_study_java_web.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void saveRentType(RentType rentType) {

    }

    @Override
    public void deleteRentType(Long id) {

    }

    @Override
    public RentType findRentTypeById(Long id) {
        return null;
    }

}
