package com.alight.request_eval.service.forms;

import org.springframework.stereotype.Service;

@Service
public class FormsService {

    private final FormRequestService formRequest;
    private final FormWrapupService formWrapup;

    public FormsService(FormRequestService formRequest, FormWrapupService formWrapup) {
        this.formRequest = formRequest;
        this.formWrapup = formWrapup;
    }


}
