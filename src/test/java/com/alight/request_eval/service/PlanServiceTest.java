package com.alight.request_eval.service;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.repository.PlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PlanServiceTest {
    @Mock
    PlanRepository repository;
    PlanService service;

    @BeforeEach
    public void setUp(){
        service = new PlanService(repository);
    }

    @Test
    public void listPlanNames() {
        //given
        //when
        Plan plan = service.createNewPlan("May", "2018");
        //then
        Assertions.assertThat(service.listPlanNames().contains("May 2018"));
    }

    @Test
    public void findPlanByName() {
    }

    @Test
    public void listMonths() {
    }

    @Test
    public void whenCreateNewPlanNameIsMonthSpaceYear() {
        //given
        //when
        Plan plan = service.createNewPlan("May", "2018");
        //then
        Assertions.assertThat(plan.getId() == "May 2018");
    }

}