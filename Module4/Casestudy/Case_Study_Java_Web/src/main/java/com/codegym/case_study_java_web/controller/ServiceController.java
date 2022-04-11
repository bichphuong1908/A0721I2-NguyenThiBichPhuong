package com.codegym.case_study_java_web.controller;
import com.codegym.case_study_java_web.model.*;
import com.codegym.case_study_java_web.service.RentTypeService;
import com.codegym.case_study_java_web.service.ServiceService;
import com.codegym.case_study_java_web.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Null;
import java.text.AttributedString;
import java.util.List;
import java.util.Optional;

@Controller
public class ServiceController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/service")
    public ModelAndView listServices(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Service> services;
        if (search.isPresent()) {
            services = serviceService.findAllByNameContaining(search.get(), pageable);
        } else {
            services = serviceService.findAll(pageable);
        }
        return new ModelAndView("service/list", "services", services);
    }

    @GetMapping("/create-service")
    public ModelAndView getCreatePage(Model model) {
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("services", new Service());
        return modelAndView;
    }

    @PostMapping("/create-service")
    public ModelAndView saveService(@ModelAttribute("services") Service service, RedirectAttributes redirectAttributes) {
        serviceService.saveService(service);
        redirectAttributes.addFlashAttribute("message", "Create success");
        return new ModelAndView("redirect:/service");
    }
//    @GetMapping("/edit-service/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id , Model model) {
//        List<ServiceType> serviceTypes = serviceTypeService.findAll();
//        List<RentType> rentTypes = rentTypeService.findAll();
//        Optional<Service> service = serviceService.findById(id);
//        if (service != null) {
//            model.addAttribute("serviceTypes", serviceTypes);
//            model.addAttribute("rentTypes", rentTypes);
//            ModelAndView modelAndView = new ModelAndView("service/edit");
//            modelAndView.addObject("services", service);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error.404");
//            return modelAndView;
//        }
//    }
//    @PostMapping("/edit-service")
//    public ModelAndView updateService(@ModelAttribute("services") Service service) {
//        serviceService.saveService(service);
//        ModelAndView modelAndView = new ModelAndView("/service/edit");
//        modelAndView.addObject("services", service);
//        modelAndView.addObject("message", "service updated successfully");
//        return new ModelAndView("redirect:/service");
//    }
    @GetMapping("/edit-service/{id}")
    public ModelAndView showEditForm(@PathVariable Long id , Model model) {
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("serviceTypes", serviceTypes);
        model.addAttribute("rentTypes", rentTypes);
        Optional<Service> service = Optional.ofNullable(serviceService.findServiceById(id));
        if (service != null) {
          ModelAndView modelAndView = new ModelAndView("service/edit");
            modelAndView.addObject("services", service);
            return modelAndView;
        } else {
           ModelAndView modelAndView = new ModelAndView("error.404");
           return modelAndView;
        }
    }
    @PostMapping("/edit-service")
    public ModelAndView updateService(@ModelAttribute("services") Service service, RedirectAttributes redirectAttributes) {
        serviceService.saveService(service);
        redirectAttributes.addFlashAttribute("message", "Delete success");
//        ModelAndView modelAndView = new ModelAndView("customer/edit");
//        modelAndView.addObject("customers", customer);
//        modelAndView.addObject("message", "customer updated successfully");
        return new ModelAndView("redirect:/service");
    }
}