package com.alight.request_eval.repository.forms;

import com.alight.request_eval.model.forms.FormRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRequestRepository extends JpaRepository<FormRequest, Long> {
}
