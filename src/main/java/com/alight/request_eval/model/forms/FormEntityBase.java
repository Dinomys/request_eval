package com.alight.request_eval.model.forms;

import com.alight.request_eval.model.Agent;
import com.alight.request_eval.model.Plan;
import com.alight.request_eval.model.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@MappedSuperclass
@EqualsAndHashCode
public class FormEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private Plan plan;

    @Enumerated(EnumType.STRING)
    private FormTypeEnum type;

    private LocalDate interactionDate;
    private LocalDate formCompletionDate;

    private ArrayList<Question> questions;
    private int totalScoreAvailable;
    private int score;
    private BigDecimal result;
    private boolean completed;
}
