package com.codegym.controller;

import com.codegym.model.Setting;
import com.codegym.service.SettingService;
import com.codegym.service.SettingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    SettingService settingService = new SettingServiceImpl();

    @GetMapping("/")
    public String showListForm(Model model){
        List<Setting> settings = settingService.getAllUser();
        model.addAttribute("settingList", settings);
        return "list";
    }

    @GetMapping("/index")
    public String showCreateForm(Model model) {
        String[] languages ={"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pages = {5, 10, 15, 20, 25};
        model.addAttribute("setting", new Setting());
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "/index";
    }

    @PostMapping("/save")
    public String update(@ModelAttribute("setting") Setting setting) {
        settingService.update(setting);
            return "redirect:/";
        }
}
