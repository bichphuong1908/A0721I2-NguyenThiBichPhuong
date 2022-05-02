package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Kẹo", 20000, "gói"));
        products.add(new Product(2,"Bánh cá", 15000, "gói"));
        products.add(new Product(3,"Hướng Dương", 40000, "gói"));
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        products.add(product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
