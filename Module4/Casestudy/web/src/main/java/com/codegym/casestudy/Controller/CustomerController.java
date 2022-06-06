package com.codegym.casestudy.Controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.customer.CustomerService;
import com.codegym.casestudy.service.customerType.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    //@GetMapping
////    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
////        List<Customer> customers = (List<Customer>) customerService.findAll();
////        if (customers.isEmpty()) {
////            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////        }
////        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        List<CustomerType> customerTypes = (List<CustomerType>) customerTypeService.findAll();
        modelAndView.addObject("customerTpye", customerTypes);
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "New customer created successfully");
        return "redirect:/customer";
    }

    @GetMapping("")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Customer> customers;
        if(search.isPresent()){
            customers = customerService.SearchByName(search.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
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

    @PostMapping("/edit-customer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("/customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
        return "redirect:/customer";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customer";
    }
}
