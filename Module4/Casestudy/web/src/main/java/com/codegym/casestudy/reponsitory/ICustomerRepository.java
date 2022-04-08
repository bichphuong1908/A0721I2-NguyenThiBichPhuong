package com.codegym.casestudy.reponsitory;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
