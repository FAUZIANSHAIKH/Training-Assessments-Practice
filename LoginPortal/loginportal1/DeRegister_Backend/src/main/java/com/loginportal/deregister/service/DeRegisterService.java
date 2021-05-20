package com.loginportal.deregister.service;

import java.util.List;

import com.loginportal.deregister.model.Authenticate;
import com.loginportal.deregister.model.Deactivate;
import com.loginportal.deregister.model.Review;
import com.loginportal.deregister.model.User;

public interface DeRegisterService {
		Deactivate deactivateUser(Authenticate authenticate);
		
		boolean updateUserStatus(User user) throws Exception;
		
		User authenticateUser(Authenticate authenticate) throws Exception;
		
	    boolean forgetUser(User user);

		boolean changeNameInReviews(User user);
		
		List<Review> getComments();
		
		boolean deleteInReviews(User user);
}
