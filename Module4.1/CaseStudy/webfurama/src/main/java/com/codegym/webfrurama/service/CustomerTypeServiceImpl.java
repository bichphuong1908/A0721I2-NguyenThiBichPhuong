package com.codegym.webfrurama.service;

import com.codegym.webfrurama.model.CustomerType;
import com.codegym.webfrurama.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService{
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
