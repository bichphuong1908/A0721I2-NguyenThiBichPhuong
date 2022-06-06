package com.codegym.webfrurama.service;

import com.codegym.webfrurama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface CustomerService {
//    List<Customer>findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void delete(Long id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
