package com.alight.request_eval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/evaluator")
public class EvaluatorController {

    @GetMapping("/form")
    public String getForm(){
        return "form";
    }
}
