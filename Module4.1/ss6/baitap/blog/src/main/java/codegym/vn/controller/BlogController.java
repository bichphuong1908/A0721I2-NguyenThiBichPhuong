package codegym.vn.controller;

import codegym.vn.model.Blog;
import codegym.vn.service.BlogService;
import codegym.vn.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blog")
    public String showListBlog(@RequestParam(name = "Blog", required = false) String name, Model model) {
        if (name != null && !name.isEmpty()) {
            model.addAttribute("blogs", blogService.findByName(name));
        } else {
            model.addAttribute("blogs", blogService.getList());
        }
        return "blog/list";
    }

    @GetMapping("/create")
    public String displayCreate(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "/blog/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.create(blog);
        return "redirect:/blog";
    }
//
//    @GetMapping("/update/{id}")
//    public String displayUpdate(Model model) {
//        Blog blog = new Blog();
//        model.addAttribute("blog", blog);
//        return "/blog/update";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute("blog") Blog blog, Model model) {
//        blogService.update(blog);
//        return "redirect:/blog";
//    }


}
