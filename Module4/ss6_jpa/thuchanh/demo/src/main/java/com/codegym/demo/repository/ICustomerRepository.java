package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import com.codegym.demo.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
