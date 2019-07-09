package com.alight.request_eval.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Manager extends PersonEntityBase implements Serializable {

    @OneToMany (mappedBy = "manager")
    private Set<Agent> agents;
}