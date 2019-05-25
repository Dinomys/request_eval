package com.alight.request_eval.repository;

import com.alight.request_eval.model.Evaluator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluatorRepository extends JpaRepository<Evaluator, Integer> {
}
