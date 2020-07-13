package com.alight.request_eval.model.persons;

import com.alight.request_eval.model.forms.Form;
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
    private Set<Form> formSet;

    @ManyToOne
    @JoinColumn(name = "managerid", referencedColumnName = "id")
    private Manager manager;

    private boolean archived;
}
