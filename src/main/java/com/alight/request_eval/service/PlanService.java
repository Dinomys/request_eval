package com.alight.request_eval.service;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PlanService {

    private final PlanRepository repository;
    private static final DateFormatSymbols DFS = new DateFormatSymbols(Locale.ENGLISH);

    @Autowired
    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    public List<String> listPlanNames() {
        return repository.findAll().stream().map(plan -> plan.getId()).collect(Collectors.toList());
    }

    public Plan findPlanByName(String name) {
        return repository.findById(name).orElse(new Plan());
    }

    public String[] listMonths() {
        return DFS.getMonths();
    }

    public Plan createNewPlan(String month, String year) {
        return new Plan(month + " " + year);
    }
}