package com.loginportal.deregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loginportal.deregister.model.Authenticate;
import com.loginportal.deregister.model.CustomPasswordEncoder;
import com.loginportal.deregister.model.Deactivate;
import com.loginportal.deregister.model.User;
import com.loginportal.deregister.model.Review;
import com.loginportal.deregister.model.AccountStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service(value = "deRegisterService")
public class DeRegisterServiceImpl implements DeRegisterService{

	
	
	@Autowired 
	CustomPasswordEncoder custompasswordencoder;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Deactivate deactivateUser(Authenticate authenticate) {
		
		String url = "http://localhost:8017/api/data/deactivate/create" ;
				Long userID = authenticate.getUserId();
				 HttpEntity<Long> httpEntity = new HttpEntity<>(userID);
			       ResponseEntity<Optional<Deactivate>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
			                new ParameterizedTypeReference<Optional<Deactivate>>() {
			                });
			        Optional<Deactivate> optional = response.getBody();
			        if(optional.isPresent())
			        	return optional.get();
			        else {
						return null;
					}
		
	}
	
	public boolean updateUserStatus(User user){
		String url = "http://localhost:8017/api/data/user/update-account-status" ;
		user.setAccountStatus(AccountStatus.DEACTIVE);
		   try {
			   HttpEntity<User> httpEntity = new HttpEntity<>(user);
		        ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
		                new ParameterizedTypeReference<Integer>() {
		                });
		        int update = response.getBody();
			if(update>0) {
				return true;
			}
			}catch(Exception e) {
				return false;
			}
		   
		return false;
	}
	
	public User authenticateUser(Authenticate authenticate){
		String url = "http://localhost:8017/api/data/user/find" ;
		String password = authenticate.getPassword();
		 try {
			 User user = new User();
			 user.setUserID(authenticate.getUserId());
			 HttpEntity<User> httpEntity = new HttpEntity<>(user);
		       ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
		                new ParameterizedTypeReference<Optional<User>>() {
		                });
		        Optional<User> optional = response.getBody();
			if(optional.isPresent()) {
				user = optional.get();
				String hashpwd= custompasswordencoder.encodeWithSalt(password,user.getPasswordHistory().getSalt1());
				if(hashpwd.equals(user.getPasswordHistory().getPwd1())) {
					return user;
				}
			}
			}catch(Exception e) {
				return null;
			}
		 
		return null;
	}
	
	@Override
	public  boolean changeNameInReviews(User user) {
		String url = "http://localhost:8017/api/data/review/change-name" ;
		try {
			
			HttpEntity<User> httpEntity = new HttpEntity<>(user);
		       ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
		                new ParameterizedTypeReference<String>() {
		                });
		     response.getBody();
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<Review> getComments() {
		String url = "http://localhost:8017/api/data/review/findAll";
		List<Review> reviewList = new ArrayList<Review>();
		try {
	
			Review[] response = restTemplate.getForObject(url, Review[].class);
						
            for(Review review : response) {
            	reviewList.add(review);
            }
            return reviewList;
		}
		catch (Exception e) {
			return reviewList;
		}
		
	}


	@Override
	public boolean forgetUser(User user) {
		
		String url = "http://localhost:8017/api/data/user/update-account-status" ;
		user.setAccountStatus(AccountStatus.PURGE);
		   try {
			   HttpEntity<User> httpEntity = new HttpEntity<>(user);
		        ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
		                new ParameterizedTypeReference<Integer>() {
		                });
		        int update = response.getBody();

			if(update>0) {
				return true;
			}
			}catch(Exception e) {
				return false;
			}
		   
		return false;
		   
		
	}

	@Override
	public boolean deleteInReviews(User user) {
		String url = "http://localhost:8017/api/data/review/delete-reviews" ;
		try {
			
			 HttpEntity<User> httpEntity = new HttpEntity<>(user);
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
	                new ParameterizedTypeReference<String>() {
	                });
	        response.getBody();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	

}




