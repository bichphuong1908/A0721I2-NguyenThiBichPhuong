package com.codegym.controller;

import com.codegym.model.Setting;
import com.codegym.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @Autowired
    private SettingService settingService;

    @GetMapping("/index")
    public ModelAndView showCreateForm() {
        String[] languages ={"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pages ={5, 10, 15, 20, 25};
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("setting", new Setting());
        return modelAndView;
    }

    @PostMapping("/save")
    public String update(@ModelAttribute("setting") Setting setting) {
        settingService.update(setting);
            return "redirect:/index";
        }
}
