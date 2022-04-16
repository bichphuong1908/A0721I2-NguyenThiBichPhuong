package com.codegym.thuchanh.controller;

import com.codegym.thuchanh.model.Question;
import com.codegym.thuchanh.model.QuestionType;
import com.codegym.thuchanh.repository.QuestionRepository;
import com.codegym.thuchanh.service.QuestionService;
import com.codegym.thuchanh.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionTypeService questionTypeService;

    @GetMapping("/")
        public String getHome(){
            return "home";
        }

    @GetMapping("/question")
    public ModelAndView listQuestion(@PageableDefault(size = 3) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Question> questions;
        if(search.isPresent()){
            questions = questionService.findAllByTitleContaining(search.get(), pageable);
        }
        else questions = questionService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/question/list");
        modelAndView.addObject("question", questions);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/question/create");
        List<QuestionType> questionTypes = (List<QuestionType>) questionTypeService.findAll();
        modelAndView.addObject("questionType", questionTypes);
        modelAndView.addObject("questionObj", new Question());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveQuestion(@ModelAttribute("questionObj") Question question) {
        question.setDateCreat(LocalDate.now());
        questionService.save(question);
        return "redirect:/question";
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id) {
//        Optional<Question> question = questionService.findById(id);
//        if (question.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/question/edit");
//            modelAndView.addObject("questionObj", question.get());
//            modelAndView.addObject("questionTypes", questionTypeService.findAll());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public String updateQuestion(@ModelAttribute("questionObj") Question question) {
//        questionRepository.save(question);
//        return "redirect:/question";
//    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/question/edit");
            modelAndView.addObject("questionObj", question.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public String updateQuestion(@ModelAttribute("questionObj") Question question) {
        questionService.save(question);
        return "redirect:/question";
    }

    /* Delete Modal */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        questionRepository.deleteById(id);
        return "redirect:/question";
    }

    @PostMapping("/delete")
    public String deleteQuestion(@ModelAttribute("question") Question question) {
        questionService.delete(question.getId());
        return "redirect:/question";
    }

    }
