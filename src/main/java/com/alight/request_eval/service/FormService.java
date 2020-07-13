package com.alight.request_eval.service;

import com.alight.request_eval.model.forms.Form;
import com.alight.request_eval.model.forms.FormTypeEnum;
import com.alight.request_eval.model.questions.Question;
import com.alight.request_eval.model.questions.QuestionInForm;
import com.alight.request_eval.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FormService {

    private FormRepository repository;
    private QuestionService questionService;

    @Autowired
    public FormService(FormRepository formRepository, QuestionService questionService) {
        this.repository = formRepository;
        this.questionService = questionService;
    }

    public Form populateForm(FormTypeEnum type, Form form) {
        Set<QuestionInForm> questions;
        switch (type) {
            case Request:
                questions = questionService.listQuestionsForRequest().stream()
                        .map(question -> new QuestionInForm())
                        .collect(Collectors.toSet());
                break;
            case Wrapup:
                questions = questionService.listQuestionsForWrapup().stream()
                        .map(question -> new QuestionInForm())
                        .collect(Collectors.toSet());
                System.out.println("printing questions");
                for (QuestionInForm q : questions){
                    System.out.println(q.getQuestion());
                }
                break;
                default:
                    QuestionInForm temp = new QuestionInForm();
                    questions = new HashSet<QuestionInForm>();
                    questions.add(temp);
                    break;
        }
        form.setQuestionInFormSet(questions);
        return form;
    }

    public int[] getAgentFormCount(long agentId, String planId) {
        int[] numberOfForms = new int[2];
        numberOfForms[0] = repository.countByPlanIdAgentIdAndType(planId, agentId, FormTypeEnum.Wrapup);
        numberOfForms[1] = repository.countByPlanIdAgentIdAndType(planId, agentId, FormTypeEnum.Request);
        return numberOfForms;
    }

    public Form createForm (FormTypeEnum formType){
        Form newForm = new Form();
        System.out.println("creating form");
        populateForm(formType, newForm);
        System.out.println("populating questions");
        return repository.save(newForm);
    }

    public Form findFormById (Long id, FormTypeEnum formType){
        return repository.findById(id).orElse(createForm(formType));
    }

}
