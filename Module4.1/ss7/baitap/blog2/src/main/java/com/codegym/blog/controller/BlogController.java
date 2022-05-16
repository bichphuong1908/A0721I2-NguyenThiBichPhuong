package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.CategoryRepository;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/blog")
    public ModelAndView listBlog(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Blog> blogs;
        if(search.isPresent()){
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
        }
        else blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blog", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Blog blog = new Blog();
        blog.setCategory(new Category());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("blog", blog);
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("blog") Blog blog) {
            blogService.save(blog);
            return "redirect:/blog";
        }
}
