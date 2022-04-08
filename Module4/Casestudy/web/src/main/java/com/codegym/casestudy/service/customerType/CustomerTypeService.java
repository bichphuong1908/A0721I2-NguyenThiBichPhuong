package com.codegym.casestudy.service.customerType;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.reponsitory.ICustomertypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomertypeRepository CustomertypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return CustomertypeRepository.findAll();
    }


    @Override
    public Optional<CustomerType> findById(Long customer_type_id) {
        return CustomertypeRepository.findById(customer_type_id);
    }

    @Override
    public void save(CustomerType customer_type) {
        CustomertypeRepository.save(customer_type);
    }

    @Override
    public void remove(Long customer_type_id) {
        CustomertypeRepository.deleteById(customer_type_id);
    }

    @Override
    public Page<CustomerType> SearchByName(String name, Pageable pageable) {
        return CustomertypeRepository.findAllByNameContaining(name, pageable);
    }

    public Page<CustomerType> findAll(Pageable pageable) {
        return CustomertypeRepository.findAll(pageable);
    }
}
