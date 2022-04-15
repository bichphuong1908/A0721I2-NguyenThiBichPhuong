package com.codygym.thi4.controller;


import com.codygym.thi4.model.Question;
import com.codygym.thi4.model.QuestionType;
import com.codygym.thi4.service.QuestionService;
import com.codygym.thi4.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    public QuestionTypeService questionTypeService;

//    @GetMapping("/list")
//    public ModelAndView listQuestion(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search) {
//        Page<Question> questions;
//        if (search.isPresent()) {
//            questions = questionService.findAllByTitleContaining(search.get(), pageable);
//        } else {
//            questions = questionService.findAll(pageable);
//        }
//        return new ModelAndView("question/list", "questions", questions);
//    }


    @GetMapping("/create-question")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/question/create");
        List<QuestionType> questionTypes = (List<QuestionType>) questionTypeService.findAll();
        modelAndView.addObject("questionType", questionTypes);
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveQuestion(@ModelAttribute("question") Question question) {
        questionService.save(question);
//        ModelAndView modelAndView = new ModelAndView("/question/list");
//        modelAndView.addObject("question", new Question());
//        modelAndView.addObject("message", "New question created successfully");
//        return modelAndView;
        return "redirect:/question";
    }

    @GetMapping("")
    public ModelAndView listQuestion(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Question> questions;
        if(search.isPresent()){
            questions = questionService.findAllByTitleContaining(search.get(), pageable);
        }
        else questions =questionService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/question/list");
        modelAndView.addObject("question", questions);
        return modelAndView;
    }

    @GetMapping("/edit-question/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/question/edit");
            modelAndView.addObject("question", question.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-question")
    public String updateQuestion(@ModelAttribute("question") Question question) {
        questionService.save(question);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("/customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
        return "redirect:/question";
    }

    @GetMapping("/delete-question/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/question/delete");
            modelAndView.addObject("question", question.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-question")
    public String deleteQuestion(@ModelAttribute("question") Question question) {
        questionService.delete(question.getId());
        return "redirect:/question";
    }

}
