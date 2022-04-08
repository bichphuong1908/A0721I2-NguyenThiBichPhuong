package com.codegym.casestudy.service.customerType;

import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerTypeService extends IGeneralService<CustomerType> {
    Page<CustomerType> SearchByName(String name, Pageable pageable);
}
