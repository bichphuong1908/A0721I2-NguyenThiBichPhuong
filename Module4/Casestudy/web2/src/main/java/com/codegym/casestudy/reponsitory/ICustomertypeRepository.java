package com.codegym.casestudy.reponsitory;

import com.codegym.casestudy.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomertypeRepository extends JpaRepository<CustomerType, Long> {
    Page<CustomerType> findAllByNameContaining(String name, Pageable pageable);
}
