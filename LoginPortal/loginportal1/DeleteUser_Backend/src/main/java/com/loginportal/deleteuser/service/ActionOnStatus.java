package com.loginportal.deleteuser.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loginportal.deleteuser.model.AccountStatus;
import com.loginportal.deleteuser.model.User;

@Service(value = "AdminActionService")
public class ActionOnStatus implements AdminActionService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public boolean performAction(AccountStatus action, long userId) {
		User r = new User();
		r.setUserID(userId);
		String url = "http://localhost:8017/api/data/user/find";
	    HttpEntity<User> httpEntity = new HttpEntity<>(r);
	    ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
	                new ParameterizedTypeReference<Optional<User>>() {});
		//Optional<User> user=employeeRepository.findById(id);
	    Optional<User> tempuser = response.getBody();
	    User user = new User();
	    if(tempuser.isPresent()) {
	    	user = tempuser.get();
	    	AccountStatus curStatus=user.getAccountStatus();
			switch(action) {
			case DELETE:
				if(curStatus.equals(AccountStatus.ACTIVE) || curStatus.equals(AccountStatus.DEACTIVE)||curStatus.equals(AccountStatus.UNCONFIRMED))
		        	user.setAccountStatus(AccountStatus.DELETE);
				break;
			case ACTIVE:
				if(curStatus.equals(AccountStatus.DELETE) || curStatus.equals(AccountStatus.PURGE))
		        	user.setAccountStatus(AccountStatus.ACTIVE);
				break;
			case PURGE:
				if(!curStatus.equals(AccountStatus.PURGE))
		        	user.setAccountStatus(AccountStatus.PURGE);
				break;
			default:
			}
	    } 	
		else {
			user = null;
			return false;
		}
		//User user = profileRepository.findById(userId).get();
		
	    String saveurl = "http://localhost:8017/api/data/user/update-account-status";
	    HttpEntity<User> httpEntitySave = new HttpEntity<>(user);
	    ResponseEntity<Integer> saveresponse = restTemplate.exchange(saveurl, HttpMethod.POST, httpEntitySave,
	                new ParameterizedTypeReference<Integer>() {});
	    if(saveresponse.getBody() == 1) {
	    	return true;
	    }
	    else {
	    	return false;
	    }
	}
	
	@Override
	public List<User> findAll(){
		String url = "http://localhost:8017/api/data/user/get-users";
	    User[] users = restTemplate.getForObject(url, User[].class);
	    List<User> userList = Arrays.asList(users);
	    //System.out.println(userList);
	    return userList;
	}

}
