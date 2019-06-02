package com.alight.request_eval.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/")
    public String slash(){
        return "index";
    }

    @GetMapping("/evaluator")
    public String getEvaluatorMain(){
        return "evaluator/evaluatorMain";
    }

    @GetMapping("/administrator")
    public String getAdministratorMain(){
        return "administrator/administratorMain";
    }

    @GetMapping("/evaluator/form")
    public String getForm(){
        return "form";
    }

    @GetMapping("/reporting")
    public String getReportingMain(){
        return "reporting/reportingMain.html";
    }
}
