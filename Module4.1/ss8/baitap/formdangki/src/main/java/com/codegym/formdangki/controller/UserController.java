package com.codegym.formdangki.controller;


import com.codegym.formdangki.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//
//    @GetMapping("/login")
//    public ModelAndView getCustomerList(@PageableDefault(size = 5) Pageable pageable) {
//        return new ModelAndView("user/index", "login", userService.findAll(pageable));
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showCreateForm(Model model) {
//        return new ModelAndView("user/create", "create", new User());
//    }
//
//
//    @PostMapping("/save")
//    public String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//        if (bindingResult.hasFieldErrors()) {
//            List<User> users = userService.findAll();
//            model.addAttribute("create", users);
//            return "user/create";
//        } else {
//            userService.save(user);
//            redirectAttributes.addFlashAttribute("message", "Create success");
//            return "redirect:/login";
//        }
//    }
//
//}
@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView=new ModelAndView("user/index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
    @PostMapping("/validateUser")
    public ModelAndView checkValidate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView("user/index");
            return modelAndView;
        } else {
            ModelAndView modelAndView=new ModelAndView("user/result");
            return modelAndView;
        }
    }
}
