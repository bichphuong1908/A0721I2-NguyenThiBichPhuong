package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.reponsitory.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> SearchByName(String name, Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
         customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByNameContaining(name, pageable);
    }
}
