package com.alight.request_eval.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class PersonEntityBase {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
}
