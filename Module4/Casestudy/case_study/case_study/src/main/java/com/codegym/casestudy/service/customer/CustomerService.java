package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findNameEmailCustomerTypeName(String name, String email, String customerTypeName, Pageable pageable);

    void save(Customer customer);

    void delete(Long id);

    Customer findById(Long id);
}
