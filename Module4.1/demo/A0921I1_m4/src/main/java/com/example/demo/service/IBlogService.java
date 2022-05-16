package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    void save();

    void edit();

    Page<Blog> getAllBlog(String author, String category, Pageable pageable );

}
