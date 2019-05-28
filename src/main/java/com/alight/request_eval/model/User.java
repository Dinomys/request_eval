package com.alight.request_eval.model;

import com.alight.request_eval.model.forms.FormEntityBase;
import com.alight.request_eval.model.forms.FormRequest;
import com.alight.request_eval.model.forms.FormWrapup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends PersonEntityBase implements Serializable {

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Agent agent;

    @OneToMany(mappedBy = "user")
    private Set<FormRequest> formRequestSet;

    @OneToMany(mappedBy = "user")
    private Set<FormWrapup> formWrapupSet;

    private ArrayList<String> roles;

    private String hashPassword;
}
