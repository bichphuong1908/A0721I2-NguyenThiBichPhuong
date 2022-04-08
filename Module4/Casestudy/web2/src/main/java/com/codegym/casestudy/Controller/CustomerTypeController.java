package com.codegym.casestudy.Controller;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.service.customerType.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customerType")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/create-customerType")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customerType/create");
        modelAndView.addObject("customerType", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomerType(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.save(customerType);
//        ModelAndView modelAndView = new ModelAndView("/customerType/list");
//        modelAndView.addObject("customer", new Customer());
//        modelAndView.addObject("message", "New customer created successfully");
        return "redirect:/customerType";
    }

    @GetMapping("")
    public ModelAndView listCustomerTypes(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<CustomerType> customerTypes;
        List<CustomerType> customerTypeList;
        ModelAndView modelAndView = new ModelAndView("/customerType/list");
        if(search.isPresent()){
            customerTypes = customerTypeService.SearchByName(search.get(), pageable);
            modelAndView.addObject("customerTypes", customerTypes);
        } else {
            customerTypeList = customerTypeService.findAll();
            modelAndView.addObject("customerTypes", customerTypeList);
        }
        return modelAndView;
    }

    @GetMapping("/edit-customerType/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<CustomerType> customer = customerTypeService.findById(id);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customerType/edit");
            modelAndView.addObject("customerType", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customerType")
    public String updateCustomerType(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.save(customerType);
//        ModelAndView modelAndView = new ModelAndView("/customerType/edit");
//        modelAndView.addObject("customerType", customerType);
//        modelAndView.addObject("message", "Customer updated successfully");
        return "redirect:/customerType";
    }

    @GetMapping("/delete-customerType/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<CustomerType> customerType = customerTypeService.findById(id);
        if (customerType.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customerType/delete");
            modelAndView.addObject("customerType", customerType.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customerType")
    public String deleteCustomerType(@ModelAttribute("customerType") CustomerType customerType) {
        customerTypeService.remove(customerType.getId());
        return "redirect:/customerType";
    }
}
