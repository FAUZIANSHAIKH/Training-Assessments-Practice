package com.loginportal.deleteuser.service;

import java.util.List;

import com.loginportal.deleteuser.model.AccountStatus;
import com.loginportal.deleteuser.model.User;

public interface AdminActionService {
	public boolean performAction(AccountStatus action, long userId);
	
	public List<User> findAll();
}
