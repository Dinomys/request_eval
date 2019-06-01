package com.alight.request_eval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String getLogin(){
        return "login.html";
    }

    @PostMapping("/index")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/evaluator")
    public String getEvaluatorMain(){
        return "evaluator/evaluatorMain.html";
    }

    @GetMapping("/administrator")
    public String getAdministratorMain(){
        return "administrator/administratorMain.html";
    }

    @GetMapping("/evaluator/form")
    public String getForm(){
        return "form.html";
    }

    @GetMapping("/reporting")
    public String getReportingMain(){
        return "reporting/reportingMain.html";
    }
}
