package com.codegym.formdangki.controller;


import com.codegym.formdangki.model.User;
import com.codegym.formdangki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/user")
//    public ModelAndView getUserList(){
//        return new ModelAndView("user/index","users",userService.findAll());
//    }

    @GetMapping("/login")
    public ModelAndView listUser(){
        List<User> users;
        users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
