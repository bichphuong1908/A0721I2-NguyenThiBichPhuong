package com.codegym.formdangki.controller;


import com.codegym.formdangki.model.User;
import com.codegym.formdangki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public ModelAndView getCustomerList(@PageableDefault(size = 5) Pageable pageable) {
        return new ModelAndView("user/index", "login", userService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/create";
    }


    @PostMapping("/save")
    public String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<User> users = userService.findAll();
            model.addAttribute("users", users);
            return "user/create";
        } else {
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/login";
        }
    }

}
