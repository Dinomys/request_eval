package com.alight.request_eval.service;

import com.alight.request_eval.model.forms.FormTypeEnum;
import com.alight.request_eval.model.questions.QuestionInForm;
import com.alight.request_eval.repository.QuestionInFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionInFormService {

    @Autowired
    private QuestionInFormRepository repository;
    private QuestionService questionService;

    public List<QuestionInForm> listQuestionsInForm (Long formId){
        return null;
    }
}
