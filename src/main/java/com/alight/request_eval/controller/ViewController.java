package com.alight.request_eval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/evaluator")
    public String getEvaluatorMain(){
        return "evaluatorMain.html";
    }

    @GetMapping("/administrator")
    public String getAdministratorMain(){
        return "administratorMain.html";
    }

    @GetMapping("/form")
    public String getForm(){
        return "form.html";
    }
}
