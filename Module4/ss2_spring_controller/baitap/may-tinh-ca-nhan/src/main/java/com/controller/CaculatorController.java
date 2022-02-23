package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @GetMapping("/")
    public ModelAndView Calculation() {
        return new ModelAndView("index");
    }

    @PostMapping("/calculator")
    public ModelAndView calculation(@RequestParam("number1") double number1, @RequestParam("number2") double number2, @RequestParam("calculator") String calculator, ModelMap model) {
        double result = 0;
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
