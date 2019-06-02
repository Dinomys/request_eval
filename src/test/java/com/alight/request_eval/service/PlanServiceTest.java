package com.alight.request_eval.service;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.repository.PlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


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
        List<Plan> list = new ArrayList<Plan>();
        list.add(new Plan("March 2018"));
        list.add(new Plan("April 2018"));
        when(repository.findAll()).thenReturn(list);
        //when
        List<String> test = service.listPlanNames();
        //then
        Assertions.assertThat(service.listPlanNames().contains("April 2018"));
    }

    @Test
    public void findPlanByName() {
    }

    @Test
    public void listMonths() {
    }

    @Test
    public void whenPlanListNotEmptyAndDoesNotContainNameNewPlanIsSaved() {
        //given
        List<Plan> list = new ArrayList<Plan>();
        list.add(new Plan("March 2018"));
        list.add(new Plan("April 2018"));
        when(repository.findAll()).thenReturn(list);
        Plan test = new Plan("May 2018");
        when(repository.save(test)).thenReturn(test);
        //when
        Plan plan = service.createNewPlan("May", "2018");
        //then
        assertEquals("May 2018", plan.getId());
    }

    @Test
    public void whenPlanListEmptyNewPlanIsSaved() {
        //given
        List<Plan> list = new ArrayList<Plan>();
        when(repository.findAll()).thenReturn(list);
        Plan test = new Plan("May 2018");
        when(repository.save(test)).thenReturn(test);
        //when
        Plan plan = service.createNewPlan("May", "2018");
        //then
        assertEquals("May 2018", plan.getId());
    }

    @Test
    public void whenPlanListNotEmptyAndContainsNameExistingPlanIsPulled() {
        //given
        List<Plan> list = new ArrayList<Plan>();
        list.add(new Plan("March 2018"));
        list.add(new Plan("April 2018"));
        when(repository.findAll()).thenReturn(list);
        //when
        Plan plan = service.createNewPlan("April", "2018");
        //then
        Mockito.verify(repository, times(1)).findById("April 2018");
    }
}