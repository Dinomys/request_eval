package com.alight.request_eval.repository;

import com.alight.request_eval.model.questions.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long> {

    /*    @Query("SELECT COUNT(f) FROM Form f WHERE PLAN_ID = ?1 AND AGENT_ID = ?2 AND type = ?3 AND f.cancelled = true")
    int countCancelledFormsByPlanIdAgentIdAndType(String planId, Long agentId, FormTypeEnum formType);*/

}
