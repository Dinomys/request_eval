package com.alight.request_eval.controller;

import com.alight.request_eval.model.forms.FormTypeEnum;
import com.alight.request_eval.model.questions.Question;
import com.alight.request_eval.service.FormService;
import com.alight.request_eval.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping (value = "/evaluator")
public class EvaluatorController {
    @Autowired
    QuestionService questionService;
    @Autowired
    FormService formService;

    @GetMapping("/formWrapup")
    public String getWrapupForm(@ModelAttribute(name="form") @Valid String formId,
                                BindingResult bindingResult,
                                Model model){
        Long id = 0l;
        try {
            id = Long.valueOf(formId);
        } catch (Exception e){};
        model.addAttribute("form", formService.findFormById(id, FormTypeEnum.Wrapup));
        System.out.println("TUTAJ");
        for (Question q: questionService.listQuestionsForWrapup()){
            System.out.println(q.getDescription());
        };
        return "evaluator/formWrapup";
    }
}
