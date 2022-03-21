package com.codogym.cms.controller;

import com.codogym.cms.model.Customer;
import com.codogym.cms.model.Province;
import com.codogym.cms.service.customer.ICustomerService;
import com.codogym.cms.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces() {
        Iterable<Province> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/lists");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/creates-provinces")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/province/creates");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/creates-provinces")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);

        ModelAndView modelAndView = new ModelAndView("/province/creates");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edits-provinces/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/edits");
            modelAndView.addObject("province", province.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edits-provinces")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.save(province);
        ModelAndView modelAndView = new ModelAndView("/province/edits");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/deletes-provinces/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Province> province = provinceService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/province/deletes");
            modelAndView.addObject("province", province.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/deletes-provinces")
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.remove(province.getId());
        return "redirect:provinces";
    }

    @GetMapping("/views-provinces/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Province> provinceOptional = provinceService.findById(id);
        if(!provinceOptional.isPresent()){
            return new ModelAndView("/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvince(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/province/views");
        modelAndView.addObject("province", provinceOptional.get());
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
