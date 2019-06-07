package com.alight.request_eval.repository;

import com.alight.request_eval.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

/*    @Query("SELECT u FROM User u WHERE u.firstname = :firstname")
    User findbyName(String name);*/

}
