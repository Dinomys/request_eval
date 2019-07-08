package com.alight.request_eval.model.forms;

import com.alight.request_eval.model.questions.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class FormWrapup extends FormEntityBase implements Serializable {

    @ManyToMany
    @JoinTable(
            name = "wrapup_questions",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn (name = "question_id"))
    private Set<Question> questions;
}
