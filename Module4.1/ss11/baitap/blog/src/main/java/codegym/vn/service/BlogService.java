package codegym.vn.service;

import codegym.vn.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    void create(Blog blog);
    void update(Blog blog);
    void delete(long id);
    List<Blog> getList();
    Blog findById(long id);
    List<Blog> findByName(String name);
    Page<Blog> findAll(Pageable pageable);
}
