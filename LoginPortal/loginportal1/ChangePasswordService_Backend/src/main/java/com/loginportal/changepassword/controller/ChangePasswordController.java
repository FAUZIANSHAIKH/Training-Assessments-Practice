package com.loginportal.changepassword.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginportal.utils.encoder.CustomPasswordEncoder;
import com.loginportal.utils.model.PasswordHistory;
import com.loginportal.utils.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/change")
@CrossOrigin(origins = "*")
@EnableSwagger2
@Api(value = "Operations pertaining to change password")
public class ChangePasswordController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;

	@PostMapping
	@ApiOperation(value = "${ChangePasswordController.change-password.value}", notes = "${ChangePasswordController.change-password.notes}", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "SUCCESS | OK"),
			@ApiResponse(code = 404, message = "NOT FOUND")
	})
	public String changePassword(@ApiParam(value = "${ChangePasswordController.change-password.param}", required = true)@RequestBody User loginUser) {
		String url = "http://localhost:8017/api/data/user/find";
		User user = new User();

		if (loginUser.getUserID() != null) {
			user.setUserID(loginUser.getUserID());
		} else {
			user.setEmailID(loginUser.getEmailID());
		}
		
		HttpEntity<User> httpEntity = new HttpEntity<>(user);
		ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<Optional<User>>() {
				});
		Optional<User> optional = response.getBody();

		return changePasswordOfUser(optional,loginUser.getPasswordHistory().getPwd1(),
				loginUser.getPasswordHistory().getPwd2());
		
	}

	private String changePasswordOfUser(Optional<User> optional, String rawOldPassword, String rawNewPassword) {
		if (optional.isPresent()) {
			
			User user = optional.get();
			PasswordHistory passwordHistory = user.getPasswordHistory();
			String storedHashedOldPassword1 =  passwordHistory.getPwd1();
			String storedHashedOldPassword2 =  passwordHistory.getPwd2();
			String storedHashedOldPassword3 =  passwordHistory.getPwd3();
			
			String storedSalt1 = passwordHistory.getSalt1();
			String storedSalt2 =  passwordHistory.getSalt2();
			String storedSalt3 =  passwordHistory.getSalt3();
			String inputHashedOldPassword = customPasswordEncoder.encodeWithSalt(rawOldPassword, storedSalt1); //old pwd from frontend
			
			
			String inputHashedNewPassword1,inputHashedNewPassword2,inputHashedNewPassword3;
			if (inputHashedOldPassword.equals(storedHashedOldPassword1)) {
				
				if(storedSalt1!=null && storedSalt2!=null && storedSalt3!=null) {
					
					 inputHashedNewPassword1 = customPasswordEncoder.encodeWithSalt(rawNewPassword, storedSalt1);
					 inputHashedNewPassword2 = customPasswordEncoder.encodeWithSalt(rawNewPassword, storedSalt2);
					 inputHashedNewPassword3 = customPasswordEncoder.encodeWithSalt(rawNewPassword, storedSalt3);
					 
						
					if((inputHashedNewPassword1.equals(storedHashedOldPassword1)) || (inputHashedNewPassword2.equals(storedHashedOldPassword2)) || (inputHashedNewPassword3.equals(storedHashedOldPassword3)))  {
					
						return "new password should not be same as last three old passwords";
					}
				}
				
				else if(storedSalt2==null) {
					 inputHashedNewPassword1 = customPasswordEncoder.encodeWithSalt(rawNewPassword, storedSalt1);
					
					if((inputHashedNewPassword1.equals(storedHashedOldPassword1))  )  {
					
						return "new password should not be same as last three old passwords";
					}
				}
				else {
					 inputHashedNewPassword1 = customPasswordEncoder.encodeWithSalt(rawNewPassword, storedSalt1);
					 inputHashedNewPassword2 = customPasswordEncoder.encodeWithSalt(rawNewPassword, storedSalt2);
					 
					if((inputHashedNewPassword1.equals(storedHashedOldPassword1)) || (inputHashedNewPassword2.equals(storedHashedOldPassword2)) )  {
					
						return "new password should not be same as last three old passwords";
					}
				}
			
				
				String newSalt = BCrypt.gensalt(12);	
				String inputHashedNewPassword = customPasswordEncoder.encodeWithSalt(rawNewPassword, newSalt);
					
				if( passwordHistory.getPwd2()==null){
						
					 passwordHistory.setPwd2( passwordHistory.getPwd1());
					 passwordHistory.setSalt2( passwordHistory.getSalt1());
						passwordHistory.setPwd1(inputHashedNewPassword);
						passwordHistory.setSalt1(newSalt);
				}
				else {
						passwordHistory.setPwd3(passwordHistory.getPwd2());
						passwordHistory.setSalt3(passwordHistory.getSalt2());
						passwordHistory.setPwd2(passwordHistory.getPwd1());
						passwordHistory.setSalt2(passwordHistory.getSalt1());
						passwordHistory.setPwd1(inputHashedNewPassword);
						passwordHistory.setSalt1(newSalt);
				}
				
				
				
				
				String url = "http://localhost:8017/api/data/password-history/update";
				HttpEntity<PasswordHistory> httpEntity = new HttpEntity<>(passwordHistory);
				ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
						new ParameterizedTypeReference<Integer>() {
						});
				int status = response.getBody();
				if (status > 0) {
					return "Password changed successfully";
				} else {
					return "Some error";
				}
			
		}
			return "Please enter correct password";
		}
		return "User doesn't exist";
	}
	
	
}

