package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    void create(Product product);
    void update(Product product);
    void delete(String id);
    List<Product> findAll();
    Product findById(String id);
}
