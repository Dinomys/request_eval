package com.alight.request_eval.model.persons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated (EnumType.STRING)
    RoleTypeEnum role;

    @ManyToMany (mappedBy = "roles")
    private Set<User> users;
}
