package com.alight.request_eval.controller;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.service.AgentService;
import com.alight.request_eval.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/administrator")
public class AdministratorController {

    @Autowired
    PlanService planService;
    AgentService agentService;


    @GetMapping("/newplan")
    public String getNewPlanForm() {
        return "administrator/newplan";
    }

    @GetMapping("/editplan")
    public String editPlan(Model model) {
        model.addAttribute("planlist", planService.listPlanNames());
        return "administrator/editplan";
    }

    @PostMapping("/editplan")
    public String pickFormToEdit(@ModelAttribute(name="pickplan") @Valid String planname,
                               BindingResult bindingResult,
                               Model model) {
        model.addAttribute("plan", planService.findPlanByName(planname));
        model.addAttribute("activeagents", agentService.listActiveAgents());
        return "administrator/editplanform";
    }

    @PostMapping("/editplanform")
    public String editPlanForm(Model model) {
        model.addAttribute("activeagents", agentService.listActiveAgents());
    return "administrator/editplanform";
    }

    @GetMapping("/users")
    public String getNewUserForm() {
        return "administrator/users";
    }

}
