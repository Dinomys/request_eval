package com.alight.request_eval.model.questions;


import com.alight.request_eval.model.forms.Form;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class QuestionInForm implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "questionId", referencedColumnName = "id")
    Question question;

    @ManyToOne
    @JoinColumn(name = "formid", referencedColumnName = "id")
    Form form;

    boolean unapplicable;
    boolean failed;
    int score;
    String comment;

}
