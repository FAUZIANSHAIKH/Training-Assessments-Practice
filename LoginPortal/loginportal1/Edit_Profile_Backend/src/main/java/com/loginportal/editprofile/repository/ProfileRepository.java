package com.loginportal.editprofile.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loginportal.editprofile.model.User;

@Repository
public interface ProfileRepository extends CrudRepository<User, Integer> {

}
