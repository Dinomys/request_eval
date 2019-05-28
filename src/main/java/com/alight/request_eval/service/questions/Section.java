package com.alight.request_eval.service.questions;

public enum Section {
    OVERVIEW ("Overview"),
    PERSONALSERVICE ("Personal Service / Customer Facing Response"),
    COMMUNICATION ("Communication"),
    KNOWLEDGE ("Knowledge"),
    TIMELINESS ("Timeliness / Research"),
    ACCURACY ("Accuracy SLA"),
    AUTOFAIL ("Auto Fail"),
    EIN ("External Info Needed")
    ;
    Section(String sectionName) {
    }
}
