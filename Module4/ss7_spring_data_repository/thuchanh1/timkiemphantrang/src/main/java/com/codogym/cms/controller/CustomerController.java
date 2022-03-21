package com.codogym.cms.controller;

import com.codogym.cms.model.Customer;
import com.codogym.cms.model.Province;
import com.codogym.cms.service.customer.ICustomerService;
import com.codogym.cms.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }


    @GetMapping("/creates-customers")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customers/creates");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/creates-customers")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customers/creates");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/customers")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customers/lists");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }


    @GetMapping("/edits-customers/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customers/edits");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edits-customers")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customers/edits");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/deletes-customers/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customers/deletes");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/deletes-customers")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
