package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    void create(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> findAll();
    Product findById(int id);
}
