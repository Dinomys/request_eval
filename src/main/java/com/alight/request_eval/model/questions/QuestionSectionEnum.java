package com.alight.request_eval.model.questions;

import lombok.Getter;

@Getter
public enum QuestionSectionEnum{
    GENERAL ("General"),
    OVERVIEW ("Overview"),
    COMMUNICATION ("Communication"),
    KNOWLEDGE ("Knowledge"),
    TIMELINESS ("Timeliness/Research"),
    PERSONALSERVICE ("Personal Service"),
    AUTOFAIL ("Auto-fail"),
    EIN ("External Info Needed");

    private String sectionName;

    QuestionSectionEnum(String sectionName) {
        this.sectionName = sectionName;
    }
}
