package com.codegym.webfrurama.controller;

import com.codegym.webfrurama.model.Customer;
import com.codegym.webfrurama.model.CustomerType;
import com.codegym.webfrurama.service.CustomerService;
import com.codegym.webfrurama.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/customer")
    public ModelAndView listCustomers(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.findAllByNameContaining(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
        modelAndView.addObject("customerTpye", customerTypes);
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()){
            List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
            model.addAttribute("customerTpye", customerTypes);
            return "/customer/create";
        }else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customerTpye", customerTypes);
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer.getId());
        return "redirect:/customer";
    }
}
