package com.codegym.baithi.controller;

import com.codegym.baithi.model.KhuyenMai;
import com.codegym.baithi.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/khuyenMai")
    public ModelAndView listKhuyenMai(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<KhuyenMai> khuyenMais;
        if(search.isPresent()){
            khuyenMais = khuyenMaiService.findAllByMucGiamGiaContaining(search.get(), pageable);
        }
        else khuyenMais = khuyenMaiService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/khuyenMai/list");
        modelAndView.addObject("khuyenMai", khuyenMais);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/khuyenMai/create");
        modelAndView.addObject("khuyenMai", new KhuyenMai());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveKhuyenMai(@Valid @ModelAttribute("khuyenMai") KhuyenMai khuyenMai, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "/khuyenMai/create";
        }else {
            khuyenMaiService.save(khuyenMai);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/khuyenMai";
        }
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        khuyenMaiService.delete(id);
        return "redirect:/khuyenMai";
    }

    @PostMapping("/delete")
    public String deleteKhuyenMai(@ModelAttribute("khuyenMai") KhuyenMai khuyenMai) {
        khuyenMaiService.delete(khuyenMai.getId());
        return "redirect:/khuyenMai";
    }
}
