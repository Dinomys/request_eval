package com.alight.request_eval.model;

import com.alight.request_eval.model.dto.AgentListDto;
import com.alight.request_eval.model.forms.Form;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Plan implements Serializable {

    @Id
    private String id;

    @OneToMany(mappedBy = "plan")
    private Set<Form> formSet;

    public Plan(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return id.equals(plan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
