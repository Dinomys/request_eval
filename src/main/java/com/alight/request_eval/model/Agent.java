package com.alight.request_eval.model;

import com.alight.request_eval.model.forms.FormEntityBase;
import com.alight.request_eval.model.forms.FormRequest;
import com.alight.request_eval.model.forms.FormWrapup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Agent extends PersonEntityBase implements Serializable {

    @OneToMany (mappedBy = "agent")
    private Set<FormRequest> formRequestSet;

    @OneToMany (mappedBy ="agent")
    private Set<FormWrapup> formWrapupSet;

    @OneToOne
    @JoinColumn (name = "userid", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "managerid", referencedColumnName = "id")
    private Manager manager;

    private boolean archived;
}
