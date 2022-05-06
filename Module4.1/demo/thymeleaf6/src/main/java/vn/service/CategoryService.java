package vn.service;

import vn.entity.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);
    void delete(int id);
    List<Category> findAll();
    Category findById(int id);
}
