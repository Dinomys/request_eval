package com.alight.request_eval.model.forms;

import com.alight.request_eval.model.persons.Agent;
import com.alight.request_eval.model.Plan;
import com.alight.request_eval.model.persons.User;
import com.alight.request_eval.model.questions.Question;
import com.alight.request_eval.model.questions.QuestionInForm;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Form {
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

    private Long requestNumber;

    private Integer totalScoreAvailable;
    private Integer score;
    private BigDecimal result;
    private Boolean completed;
    private Boolean cancelled;

    ArrayList<QuestionInForm> questions;

}
