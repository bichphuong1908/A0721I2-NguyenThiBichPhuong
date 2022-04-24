package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("")
    public String Calculation() {

        return  "index";
    }

    @PostMapping("/calculator")
    public ModelAndView calculation(@RequestParam("number1") float number1, @RequestParam("number2") float number2, @RequestParam("calculator") String calculator, ModelMap model) {
        float result = 0;
        switch (calculator) {
            case "Addition(+)":
                result = number1 + number2;
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                break;
            case "Multiplication(X)":
                result = number1 * number2;
                break;
            case "Division(/)":
                result = number1 / number2;
                break;
        }

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("calculator", calculator);
        return new ModelAndView("index","result",result);
    }
}
