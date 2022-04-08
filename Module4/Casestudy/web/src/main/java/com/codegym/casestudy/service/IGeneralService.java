package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    List<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
    Page<T>SearchByName(String name, Pageable pageable);
}
