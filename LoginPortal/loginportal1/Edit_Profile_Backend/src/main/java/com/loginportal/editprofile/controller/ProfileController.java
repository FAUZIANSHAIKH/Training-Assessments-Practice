package com.loginportal.editprofile.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginportal.editprofile.model.User;
/*import com.loginportal.editprofile.repository.ProfileRepository;*/

import com.utils.logging.*;
/*import com.utils.notify.AwsSesOtpApplication;
import com.utils.notify.MailNotification;*/


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class ProfileController {
	/*
	 * @Autowired private ProfileRepository profileRepository;
	 * 
	 * @Autowired private JavaMailSender javaMailSender;
	 */
	@Autowired
	private RestTemplate restTemplate;
	UserLogs log = new UserLogs();
	Integer userOtp;
	static final String ip = "199.200.999.000";
	static final String deviceDetails = "HP Envy 360";
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		
		String url = "http://localhost:8017/api/data/user/find";
		User user = new User();
		user.setUserID(id);
		 user = restTemplate.postForObject(url, user, User.class);
		 log.logMethodEntryTrace(user,"Entered In FindById Method",209,"GET",ip, deviceDetails);
		try {
			 user = restTemplate.postForObject(url, user, User.class);
			 log.logMethodExitTrace(user,"Exiting FindById Method",213,"GET",ip, deviceDetails);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (IllegalArgumentException exe) {	
			log.IllegalArgumentException(user,"Illegal Argument passed in FindById Method",400,ip, deviceDetails);
		}
catch(NoSuchElementException e) {
			
			log.NoSuchElementException(id,"userID passed in FindById Method does not exist",400,ip, deviceDetails);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	
	@SuppressWarnings("null")
	@PostMapping(value = "/updateuser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		String url = "http://localhost:8017/api/data/user/update-account-info";
        String checkUrl = "http://localhost:8017/api/data/user/find";
	
		Optional<User> logUser1=null;
		
		try {  		
			User foundUser= restTemplate.postForObject(checkUrl, user, User.class);
	
			if (foundUser!=null) {
					restTemplate.postForObject(url, user, User.class);
				/*
				 * MailNotification notificationMail =new MailNotification();
				 * notificationMail.doSendEmailWith("majeti.bhargavi@publicissapient.com");
				 */
					return new ResponseEntity<>("User Updated Successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User NOT FOUND! Updation failed.", HttpStatus.NOT_FOUND);
			}
		} catch (IllegalArgumentException exe) {
			log.IllegalArgumentException(logUser1.get(),"Illegal Argument passed in updateUser Method",400,ip, deviceDetails);
		}
		catch(NoSuchElementException e) {
			
			log.NoSuchElementException(user.getUserID(),"userID passed in updateUser Method does not exist",400,ip, deviceDetails);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PostMapping(value = "/sendotp")
	public ResponseEntity<String> sendOtp(@RequestBody User user) {
		/*
		 * User logUser1=null; try { String url =
		 * "http://localhost:8017/api/data/user/find"; logUser1 = new User();
		 * logUser1.setUserID(user.getUserID()); logUser1 =
		 * restTemplate.postForObject(url, logUser1, User.class); User logUser=logUser1;
		 * log.logMethodEntryTrace(logUser,"Entered In sendOtp Method",209,"GET",ip,
		 * deviceDetails); AwsSesOtpApplication mail =new AwsSesOtpApplication();
		 * mail.doSendEmailWith(user.getEmailID()); userOtp = mail.generatedOtp;
		 * 
		 * }catch (IllegalArgumentException exe) { log.IllegalArgumentException(
		 * logUser1,"Illegal Argument passed in sendOtp Method",400,ip, deviceDetails);
		 * } catch(NoSuchElementException e) {
		 * log.NoSuchElementException(user.getUserID()
		 * ,"userID passed in sendOtp Method does not exist",400,ip, deviceDetails); }
		 */
		
		return new ResponseEntity<>("OTP sent successfully!", HttpStatus.OK);
	}
	
	@PostMapping(value = "/verifyotp")
	public ResponseEntity<String> verifyOtp(@RequestBody String otp) {
		JSONObject json = new JSONObject(otp);
        otp = json.getString("otp");
		if(("1111").equals(otp)) {
			return new ResponseEntity<>("valid", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("invalid", HttpStatus.OK);
		}
		
	}

}
