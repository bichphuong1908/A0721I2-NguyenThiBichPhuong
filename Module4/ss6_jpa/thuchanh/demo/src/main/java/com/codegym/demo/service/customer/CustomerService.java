package com.codegym.demo.service.customer;

import com.codegym.demo.model.Customer;
import com.codegym.demo.repository.ICustomerRepository;
import com.codegym.demo.service.customer.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> findAll() {
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
}
