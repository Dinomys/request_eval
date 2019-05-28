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
public class Plan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "plan")
    private Set<FormRequest> formRequestSet;

    @OneToMany
    private Set<FormWrapup> formWrapupSet;
}
