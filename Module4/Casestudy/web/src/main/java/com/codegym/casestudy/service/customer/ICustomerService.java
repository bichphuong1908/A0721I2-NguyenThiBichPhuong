package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> SearchByName(String name, Pageable pageable);
}
