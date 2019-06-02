package com.alight.request_eval.controller;

import com.alight.request_eval.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/administrator")
public class AdministratorController {

    @Autowired
    PlanService planService;


    @GetMapping("/newplan")
    public String getNewPlanForm() {
        return "administrator/newplan";
    }

    @GetMapping("/editplan")
    public String editPlan(Model model) {
        model.addAttribute("planlist", planService.listPlanNames());
        return "administrator/editplan";
    }

    @GetMapping("/users")
    public String getNewUserForm() {
        return "administrator/users";
    }

}
