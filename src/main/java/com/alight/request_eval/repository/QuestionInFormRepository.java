package com.alight.request_eval.repository;

import com.alight.request_eval.model.questions.QuestionInForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionInFormRepository extends JpaRepository <QuestionInForm, Long> {

/*    @Query("SELECT COUNT(f) FROM Form f WHERE PLAN_ID = ?1 AND AGENT_ID = ?2 AND type = ?3 AND f.cancelled = true")
    int countCancelledFormsByPlanIdAgentIdAndType(String planId, Long agentId, FormTypeEnum formType);*/

    @Query("SELECT (q) FROM QuestionInForm q WHERE q.form IN ?1")
    List<QuestionInForm> findQuestionsInFomr(long formId);
}
