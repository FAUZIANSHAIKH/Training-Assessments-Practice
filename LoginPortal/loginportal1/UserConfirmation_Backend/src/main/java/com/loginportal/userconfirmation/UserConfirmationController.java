package com.loginportal.userconfirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginportal.userconfirmation.model.AccountStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.loginportal.userconfirmation.service.UserService;
import com.loginportal.userconfirmation.model.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.NoSuchElementException;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class UserConfirmationController{
	
//	@Autowired
//    private JavaMailSender javaMailSender;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private UserService employeeService;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	public UserConfirmationController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	private String response = "response";
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/sendmail")
	public Object sendingEmail(@RequestBody User id) {
		//long id = Long.parseLong(userid);
		//System.out.println(userid);
		
		ObjectNode o = mapper.createObjectNode();
		
		
		try {
			User e = employeeService.findById(id.getUserID());
			//o.put("response", "Email Has been successfully sent"); 
			if(e.getAccountStatus().toString().equals("ACTIVE")) {
				o.put(response, "User already verified");
			}
			else {
				//employeeService.sendEmailWithSES(e.getUserID(), e.getEmailID());
        		//employeeService.awsSES(e.getUserID());
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("sanketgiri48@gmail.com");
				message.setTo(e.getEmailID());
				message.setSubject("Account Confirmation Link");
				String s = "Click on the following link to activate your account : ";
				message.setText(s + "http://http://ec2-18-235-29-68.compute-1.amazonaws.com:8006/#/confirmmail/" + e.getUserID());
				mailSender.send(message);
				o.put("response", "Email Has been successfully sent");
//				e.setEmailConfirmationFlag(true);
//				Date date = new Date();    
//			    Timestamp accountCreationTime = new Timestamp(date.getTime());
//				e.setAccountCreationTime(accountCreationTime);
//	        	Register a = employeeService.save(e);
//	        	if(a != null) {
//	        		//o.put(response, "Congrats! Your account has been successfully activated...");
//	        		employeeService.sendEmailWithSES();
//	        		o.put("response", "Email Has been successfully sent");
//	        	}
//	        	else {
//	        		o.put(response, "Error...");
//	        	}
			}
		}
    	catch(NullPointerException e) {
    		o.put(response, "Not a valid id");
    	}
		return o;
	}
    
	/*
	 * public void sendEmail(String email, String uid) { SimpleMailMessage msg = new
	 * SimpleMailMessage(); msg.setTo(email);
	 * msg.setSubject("Account Activation Link"); String url =
	 * "http:localhost:8765/api/v1/confirmmail/" + uid;
	 * msg.setText("Click on the following link to activate your account :" + url,
	 * "UTF-8", "html"); javaMailSender.send(msg); }
	 */
    
    @GetMapping(value="/confirmmail/{uid}")
   	public Object confirmingEmail(@PathVariable("uid") String userId) {
    	long id = Long.parseLong(userId);
    	
    	ObjectNode o = mapper.createObjectNode();
    	
    	try {
    		User e = employeeService.findById(id);
    		
        	if(e.getAccountStatus().toString().equals("ACTIVE")) {
        		o.put(response, "User already verified");
        	}
        	else {
        		e.setAccountStatus(AccountStatus.ACTIVE);
            	User a = employeeService.save(e);
            	
            	if(a != null) {
            		o.put(response, "Congrats! Your account has been successfully activated...");
            	}
            	else {
            		o.put(response, "Error...");
            	}
        	}
    	}
    	catch(NullPointerException e) {
    		o.put(response, "Not a valid id");
    	}
    	
    	//String email = "sanketgiri48@gmail.com";
        //sendEmail(email,uid);
   		//return "<h1>Congrats! Your account with UserId : " + userId + " has been successfully activated...</h1>";
		return o;
    }
}
