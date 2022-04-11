package com.codegym.case_study_java_web.service;

import com.codegym.case_study_java_web.model.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
    void saveCustomerType(CustomerType customerType);
    void deleteCustomerType(Long id);
    CustomerType findCustomerTypeById(Long id);
}
