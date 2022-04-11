package com.codegym.casestudy.service.customer.impl;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.repository.customer.CustomerRepository;
import com.codegym.casestudy.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findNameEmailCustomerTypeName(String name, String email, String customerTypeName, Pageable pageable) {
        return customerRepository.findAllByNameContainingOrEmailOrCustomerTypeName(name, email, customerTypeName, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
