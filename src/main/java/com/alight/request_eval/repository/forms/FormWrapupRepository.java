package com.alight.request_eval.repository.forms;

import com.alight.request_eval.model.forms.FormWrapup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormWrapupRepository extends JpaRepository<FormWrapup, Long> {
}
