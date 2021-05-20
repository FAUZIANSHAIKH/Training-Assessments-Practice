package com.loginportal.register.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginportal.register.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer>{
	

}
