package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TudienController {
    @GetMapping()
    public String getConvert() {
        return "index";
    }
    @GetMapping (path = "/dich")
    public String dich(@RequestParam float search, Model model) {
                return "dich";
    }
}
