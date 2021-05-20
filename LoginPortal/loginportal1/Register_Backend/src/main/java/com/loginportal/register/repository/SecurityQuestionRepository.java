package com.loginportal.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginportal.register.model.SecurityQuestion;


@Repository("securityQuestionRepository")

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion,Integer> {

}
