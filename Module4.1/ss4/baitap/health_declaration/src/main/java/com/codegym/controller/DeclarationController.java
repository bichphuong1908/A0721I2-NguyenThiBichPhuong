package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.DeclarationService;
import com.codegym.service.DeclarationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeclarationController {
    DeclarationService declarationService = new DeclarationServiceImpl();


    @GetMapping("/")
    public String showListForm(Model model){
        List<Declaration> declarations = declarationService.findAll();
        model.addAttribute("declarations", declarations);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        String[] nationalitys ={"English", "Vietnamese", "Japanese", "Chinese"};
        String[] sexs = {"Male", "Female"};
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("nationalitys", nationalitys);
        model.addAttribute("sexs", sexs);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("declaration") Declaration declaration) {
        declarationService.save(declaration);
        return "redirect:/";
    }
}
