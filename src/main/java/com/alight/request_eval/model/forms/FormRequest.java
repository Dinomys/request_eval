package com.alight.request_eval.model.forms;

import com.alight.request_eval.model.questions.Question;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class FormRequest extends FormEntityBase implements Serializable {

    @ManyToMany
    @JoinTable (
            name = "request_questions",
            joinColumns = @JoinColumn (name = "form_id"),
            inverseJoinColumns = @JoinColumn (name = "question_id"))
    private Set<Question> questions;

}
