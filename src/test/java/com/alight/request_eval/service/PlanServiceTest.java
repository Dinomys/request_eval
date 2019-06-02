package com.alight.request_eval.service;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.repository.PlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlanServiceTest {
    PlanRepository repository;
    PlanService service = new PlanService(repository);

    @Test
    public void listPlanNames() {
    }

    @Test
    public void findPlanByName() {
    }

    @Test
    public void listMonths() {
    }

    @Test
    public void createNewPlan() {
        //given
        //when
        service.createNewPlan("May", "2018");
        //then
        Assertions.assertThat(!service.listPlanNames().isEmpty());
    }
}