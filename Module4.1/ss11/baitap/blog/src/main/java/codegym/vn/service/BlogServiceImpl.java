package codegym.vn.service;

import codegym.vn.model.Blog;
import codegym.vn.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(long id) {
        blogRepository.deleteById(id);
//        Optional<Blog> blog = blogRepository.findById(id);
////        if (blog != null) {
////            blogRepository.delete(blog);
////        }
    }

    @Override
    public List<Blog> getList() {
      List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(b -> blogs.add(b));
        return blogs;
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByName(String name) {
        return null;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return null;
    }
}
