package com.alight.request_eval.service;

import com.alight.request_eval.model.forms.Form;
import com.alight.request_eval.model.forms.FormTypeEnum;
import com.alight.request_eval.model.questions.Question;
import com.alight.request_eval.model.questions.QuestionInForm;
import com.alight.request_eval.repository.FormRepository;
import com.alight.request_eval.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Form populateForm (FormTypeEnum type, Form form){
        List<QuestionInForm> questions = new ArrayList<>();

        switch (type){
            case Request:
                questions = questionService.listQuestionsForRequest().stream()
                    .map(question -> new QuestionInForm(question))
                    .collect(Collectors.toList());
                break;
            case Wrapup:
                questions = questionService.listQuestionsForWrapup().stream()
                        .map(question -> new QuestionInForm(question))
                        .collect(Collectors.toList());
                break;
        }

        form.setQuestions(null);

    return null;
    }

    public int[] getAgentFormCount (long agentId, String planId){
        int [] forms = new int[2];
        forms[0] = repository.countByPlanIdAgentIdAndType(planId, agentId, FormTypeEnum.Wrapup);
        forms[1] = repository.countByPlanIdAgentIdAndType(planId, agentId, FormTypeEnum.Request);
        return forms;
    }

}
