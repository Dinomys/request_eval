package com.alight.request_eval.repository;

import com.alight.request_eval.model.forms.Form;
import com.alight.request_eval.model.forms.FormTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

    @Query("SELECT COUNT(f) FROM Form f WHERE PLAN_ID = ?1 AND AGENT_ID = ?2 AND type = ?3")
    int countByPlanIdAgentIdAndType(String planId, Long agentId, FormTypeEnum formType);
}
