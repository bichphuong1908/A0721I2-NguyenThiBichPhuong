package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Kẹo", 20000, "gói"));
    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(String id) {
        return null;
    }
}
