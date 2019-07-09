package com.alight.request_eval.model.questions;

import com.alight.request_eval.model.forms.Form;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated (EnumType.STRING)
    QuestionSectionEnum section;

    String description;
    Integer maxScore;

    Boolean canBeUnapplicable;
    Boolean autoFailQuestion;

    Boolean formRequest;
    Boolean formWrapup;
}

