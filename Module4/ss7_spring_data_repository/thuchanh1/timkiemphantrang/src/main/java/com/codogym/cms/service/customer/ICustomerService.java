package com.codogym.cms.service.customer;

import com.codogym.cms.model.Customer;
import com.codogym.cms.model.Province;
import com.codogym.cms.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

}
