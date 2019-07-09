package com.alight.request_eval.model.questions;

public class QuestionInForm {

    Question question;
    boolean unapplicable;
    boolean failed;
    int score;
    String comment;

    public QuestionInForm(Question question) {
        this.question = question;
    }
}
