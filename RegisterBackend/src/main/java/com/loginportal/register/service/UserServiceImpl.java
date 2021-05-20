package com.loginportal.register.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.loginportal.register.model.CustomPasswordEncoder;
import com.loginportal.register.model.Password;
import com.loginportal.register.model.User;
import com.loginportal.register.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
    @Qualifier(value = "userRepository")
    UserRepository userRepository;
	
	@Autowired 
	CustomPasswordEncoder cutompasswordencoder;
	
	@Autowired
	RestTemplate restTemplate;
	
    public UserServiceImpl(){
        this.userRepository = userRepository;
    }
    
	public User saveUser(User user) {
		
		String url = "http://localhost:8017/api/data/user/create";

		String salt1 = BCrypt.gensalt(12);
		Password pwd = user.getPasswordHistory();
		String hashpwd1= cutompasswordencoder.encodeWithSalt(pwd.getPwd1(),salt1);
		pwd.setPwd1(hashpwd1);
		pwd.setSalt1(salt1);
		user.setPasswordHistory(pwd);
		
		 HttpEntity<User> httpEntity = new HttpEntity<>(user);
		 
	       ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
	                new ParameterizedTypeReference<User>() {
	                });
    	return response.getBody();
	}
	
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	 
}
