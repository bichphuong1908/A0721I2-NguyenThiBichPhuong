package com.codegym.casestudy.Controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.customer.CustomerService;
import com.codegym.casestudy.service.customerType.CustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @GetMapping("/customer")
//    public ModelAndView listCustomers(@PageableDefault(size = 2) Pageable pageable, @RequestParam("search") Optional<String> search) {
//        Page<Customer> customers;
//        if (search.isPresent()) {
//            customers = customerService.findAllByNameContaining(search.get(), pageable);
//        } else {
//            customers = customerService.findAll(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

//    @GetMapping("/customer")
//    public ModelAndView getCustomerList(@PageableDefault(size = 3) Pageable pageable) {
//        return new ModelAndView("customer/list", "customer", customerService.findAll(pageable));
//    }

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
    public Object saveCustomer(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
//        customerService.save(customer);
//        return "redirect:/customer";
        if (bindingResult.hasFieldErrors()){
            List<CustomerType> customerTypes = customerTypeService.findAll();
            modelAndView.addObject("customerType", customerTypes);
            return new ModelAndView("/customer/create");
        }else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/customer";
        }
    }

    @PostMapping("/search")
    public String handleSearch(@RequestParam("search") String search, Pageable pageable , Model model) {
        Page<Customer> customers = customerService.SearchByName(search , pageable);
        model.addAttribute("customers" , customers);
        return "/customer/list";
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
        modelAndView.addObject("customer", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
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
