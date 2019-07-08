package com.alight.request_eval.model.questions;

import com.alight.request_eval.model.forms.FormRequest;
import com.alight.request_eval.model.forms.FormWrapup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Set<FormRequest> request;

    @ManyToMany
    private Set<FormWrapup> wrapups;

    QuestionSection section;

    String description;

    int maxScore;

    boolean canBeUnapplicable;
    boolean unapplicable;
    boolean autoFailQuestion;
    boolean failed;
    int score;
    String comment;

    boolean requestEval;
    boolean wrapup;
}

