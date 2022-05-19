package com.codegym.validate.controller;


import com.codegym.validate.model.User;
import com.codegym.validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView getUserList(){
        return new ModelAndView("index","users", userService.findAll());
    }
}
