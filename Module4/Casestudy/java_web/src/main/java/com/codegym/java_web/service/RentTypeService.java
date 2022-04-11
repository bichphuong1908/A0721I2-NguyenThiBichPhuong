package com.codegym.java_web.service;

import com.codegym.java_web.model.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    void saveRentType (RentType rentType);
    void deleteRentType(Long id);
    RentType findRentTypeById(Long id);
}
