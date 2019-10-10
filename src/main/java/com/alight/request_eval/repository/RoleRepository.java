package com.alight.request_eval.repository;

import com.alight.request_eval.model.persons.Role;
import com.alight.request_eval.model.persons.RoleTypeEnum;
import com.alight.request_eval.model.persons.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository <Role, Long> {

}