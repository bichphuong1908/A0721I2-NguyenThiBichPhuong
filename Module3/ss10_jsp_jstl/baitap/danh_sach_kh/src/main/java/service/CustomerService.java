package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    void create(Customer customer);
}
