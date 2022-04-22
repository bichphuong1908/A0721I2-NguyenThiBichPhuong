package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping()
    public String getConvert() {
        return "index";
    }

    @GetMapping (path = "/chuyen")
    public String chuyen(@RequestParam float usd, @RequestParam float rate, Model model) {
        float vnd=usd*rate;
//        model.addAttribute("usd", vnd);
//        model.addAttribute("rate", vnd);
        model.addAttribute("vnd", vnd);
        return "chuyen";
    }
}
