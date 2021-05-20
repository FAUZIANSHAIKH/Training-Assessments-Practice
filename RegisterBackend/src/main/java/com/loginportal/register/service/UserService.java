package com.loginportal.register.service;

import java.util.List;

import com.loginportal.register.model.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> findAll();

}
