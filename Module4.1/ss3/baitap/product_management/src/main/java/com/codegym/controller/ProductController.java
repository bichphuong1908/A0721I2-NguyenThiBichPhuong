package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        String[] categorys ={"gói", "thùng"};
        model.addAttribute("product", new Product());
        model.addAttribute("categorys", categorys);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, Model model) {
        productService.update(product);
        model.addAttribute("product", product);
        return "/list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable("id") Product product, Model model) {
        model.addAttribute("product", product);
        return "/view";
    }

    @GetMapping("/view")
    public String viewProductByParam(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("product") Product product) {
        productService.delete(product.getId());
        return "redirect:/list";
    }


}
