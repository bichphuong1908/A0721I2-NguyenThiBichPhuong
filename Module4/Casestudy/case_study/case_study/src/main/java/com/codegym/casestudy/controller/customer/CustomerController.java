package com.codegym.casestudy.controller.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.model.user.User;
import com.codegym.casestudy.service.customer.CustomerService;
import com.codegym.casestudy.service.customer.CustomerTypeService;
import com.codegym.casestudy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String customerList(@RequestParam("search") Optional<String> search, @PageableDefault(size = 5) Pageable pageable, Model model,  Principal principal) {
        Page<Customer> customers;
        if (search.isPresent()) {
            customers = customerService.findNameEmailCustomerTypeName(search.get(), search.get(), search.get(), pageable);
            model.addAttribute("search", search.get());
        } else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customer", customers);
        User user = userService.getUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "customer/customerList";
    }

    @GetMapping("/create")
    public String showCreateCustomerForm(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerType", customerTypes);
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            List<CustomerType> customerTypes = customerTypeService.findAll();
            model.addAttribute("customerType", customerTypes);
            return "/customer/create";
        } else {
            customerService.save(customer);
            return "redirect:/user/customer/";
        }
    }

    @GetMapping("{id}/edit")
    public String showEditCustomerForm(@PathVariable Long id, Model model){
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerType", customerTypes);
        model.addAttribute("customers", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("edit")
    public String editCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/user/customer/";
    }

    @GetMapping("{id}/delete")
    public  String showDeleteCustomerForm(@PathVariable Long id, Model model){
        model.addAttribute("customers", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("delete")
    public String deleteCustomer(Long id){
        customerService.delete(id);
        return "redirect:/user/customer/";
    }

    @GetMapping("{id}/view")
    public String viewCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customers", customerService.findById(id));
        return "/customer/view";
    }

}
