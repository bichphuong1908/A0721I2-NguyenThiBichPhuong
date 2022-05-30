package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.CategoryRepository;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

//    @GetMapping("/blog")
//    public ModelAndView listBlog(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search){
//        Page<Blog> blogs;
//        if(search.isPresent()){
//            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
//        }
//        else blogs = blogService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blog", blogs);
//        return modelAndView;
//    }
//
//
//    @GetMapping("/create")
//    public String showCreateForm(Model model) {
//        Blog blog = new Blog();
//        blog.setCategory(new Category());
//        model.addAttribute("categories", categoryRepository.findAll());
//        model.addAttribute("blog", blog);
//        return "blog/create";
//    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute("blog") Blog blog) {
//            blogService.save(blog);
//            return "redirect:/blog";
//        }
//
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable long id) {
//        blogService.delete(id);
//        return "redirect:/blog";
//    }
//
//    @PostMapping("/delete")
//    public String deleteKhuyenMai(@ModelAttribute("blog") Blog blog) {
//        blogService.delete(blog.getId());
//        return "redirect:/blog";
//    }

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        List<Category> categories = categoryRepository.findAll();
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateCustomer(@PathVariable Long id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }

}
