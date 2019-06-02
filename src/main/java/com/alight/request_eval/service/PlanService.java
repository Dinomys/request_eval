package com.alight.request_eval.service;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {

    private final PlanRepository repository;

    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    public List<String> listPlanNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (Plan p : repository.findAll()) {
            names.add(p.getId());
        }
        return names;
    }

    public Plan findPlanByName(String name) {
        return repository.findById(name).get();
    }
}