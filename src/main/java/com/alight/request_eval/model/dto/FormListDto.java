package com.alight.request_eval.model.dto;

import com.alight.request_eval.model.Plan;
import com.alight.request_eval.model.forms.FormEntityBase;
import com.alight.request_eval.model.forms.FormTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormListDto {
    private String agentName;
    private FormTypeEnum formType;
    private boolean completed;
    private Plan plan;

    public FormListDto(FormEntityBase form) {
        this.agentName = form.getAgent().getFirstName() + " " + form.getAgent().getLastName();
        this.formType = form.getType();
        this.completed = form.isCompleted();
        this.plan = form.getPlan();
    }
}
