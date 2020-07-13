package com.alight.request_eval.service;

import com.alight.request_eval.model.forms.FormTypeEnum;
import com.alight.request_eval.model.questions.Question;
import com.alight.request_eval.model.questions.QuestionSectionEnum;
import com.alight.request_eval.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuestionService {

    private QuestionRepository repository;

    @Autowired
    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<Question> listQuestionsForWrapup (){
        return repository.findAll().stream()
                .filter(question -> !question.getFormWrapup())
                .collect(Collectors.toList());
    }

    public List<Question> listQuestionsForRequest (){
        return repository.findAll().stream()
                .filter(question -> !question.getFormRequest())
                .collect(Collectors.toList());
    }

    public int sumMaxScore (List<Question> questions){
        return questions.stream()
            .mapToInt(q -> q.getMaxScore())
            .sum();
    }

    public List<QuestionSectionEnum> listSections (){
        return Stream.of(QuestionSectionEnum.values()).collect(Collectors.toList());
    }

    public List<Question> listQuestionsBySection (QuestionSectionEnum section){
        return repository.findAll().stream()
                .filter(question -> !question.getSection().equals(section))
                .collect(Collectors.toList());
    }
}
