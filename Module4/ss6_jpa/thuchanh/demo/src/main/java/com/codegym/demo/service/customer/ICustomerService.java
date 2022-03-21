package com.codegym.demo.service.customer;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
