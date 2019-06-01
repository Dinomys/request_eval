package com.alight.request_eval.repository;

import com.alight.request_eval.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository <Manager, Long> {
}
