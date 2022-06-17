package com.codegym.module4.controller;

import com.codegym.module4.model.Promotion;
import com.codegym.module4.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/promotion")
    public ModelAndView listPromotion(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Promotion> promotions;
        if(search.isPresent()){
            promotions = promotionService.findAllByDiscountContaining(search.get(), pageable);
        } else {
            promotions = promotionService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/promotion/list");
        modelAndView.addObject("promotions", promotions);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/promotion/create");
        modelAndView.addObject("promotion", new Promotion());
        return modelAndView;
    }

    @PostMapping("/save")
    public String savePromotion(@Validated @ModelAttribute("promotion") Promotion promotion, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()){
            return "/promotion/create";
        }else {
            promotionService.save(promotion);
            redirectAttributes.addFlashAttribute("message", "Create success");
            return "redirect:/promotion";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        promotionService.delete(id);
        return "redirect:/promotion";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("promotion") Promotion promotion) {
        promotionService.delete(promotion.getId());
        return "redirect:/promotion";
    }
}
