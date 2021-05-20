package com.loginportal.forgotpassword.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.loginportal.forgotpassword.model.CustomPasswordEncoder;
import com.loginportal.forgotpassword.model.Request;
import com.loginportal.forgotpassword.model.SecurityQuestion;
import com.loginportal.forgotpassword.model.User;

import io.swagger.annotations.Api;

import org.springframework.security.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/forgotpassword")
@Api(value="forgot password",description="forgot password service")
public class ForgotPasswordController {
	
	 
	@Value("${app.choice2}")
	int choice2;
	@Value("${app.link}")
	String link;
	@Value("${app.choice1}")
	int choice1;
	@Value("${app.choice3}")
	int choice3;
	@Value("${app.l1}")
	int l1;
	@Value("${app.l2}")
	int l2;
String otpSent="";
	private final MailSender mailSender;

	@Autowired
	public ForgotPasswordController(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	String email;
	@Autowired
	private CustomPasswordEncoder cpe;
	@Autowired
	private RestTemplate resttemplate;

	@Autowired
	private ObjectMapper mapper;
	String otp;
	String status = "status";
	String fal = "false";
	String tru = "true";
	String jsonLogInfo = "returning the json object to react.....";
	String jsonObjInit = "jsonObject initialised......";
	String userurl = "http://localhost:8017/api/data/user/find";
	@CrossOrigin(origins = "*")

	@PostMapping("/uic")

	public String getValidation(@RequestBody User p) {

		logger.info("validating email......");
		logger.debug("retrieving entered email address.....");
		ObjectNode jsonObject = mapper.createObjectNode();
		System.out.println(p);
		

		User obj = resttemplate.postForObject(userurl, p, User.class);
		
		if (obj != null) {
			logger.info("email successfully authenticated......");
			jsonObject.put(status, tru);

		} else {

			logger.warn("Unregistered email......");
			jsonObject.put(status, fal);

		}

		logger.debug(jsonLogInfo);
		return jsonObject.toString();

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/otp")
	public String validateOTP(@RequestBody Request p) {
		logger.info("Validating OTP......");
		ObjectNode jsonObject = mapper.createObjectNode();
		
		 otp=Integer.toString(p.getOtp());
		logger.debug(jsonObjInit);
		if ((otpSent.equals(otp))) {
			logger.info("Entered OTP is valid......");
			jsonObject.put(status, tru);
			
		} else {
			logger.warn("Invalid OTP......");
			jsonObject.put(status, fal);
		}
		logger.debug(jsonLogInfo);
		return jsonObject.toString();

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/mts")
	public String methodToSet(@RequestBody Request p) {

		email = p.getEmail();
		System.out.println(email);
		logger.debug("retrieving email......");
		ObjectNode jsonObject = mapper.createObjectNode();
		logger.debug(jsonObjInit);
		int c = p.getChoice();
		logger.info("User Selected {}......", c);
		if (c==choice1) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("mamidid@gmail.com");
			message.setTo(email);
			//String url="http://localhost:9210/generatetoken";
		//	String token=resttemplate.getForObject(url,String.class);
			message.setSubject("LoginPortal Password Assistance");
			
		
			message.setText("please click on the link to reset your password\n"+link);
			
			mailSender.send(message);
           
			logger.info("succesfully sent link");
			jsonObject.put("status", tru);

		}


		if (c==choice2) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("mamidid@gmail.com");
			message.setTo(email);
			Long x = (long) ((Math.random() * (l1 - l2)) + l2);
			String y = Long.toString(x);
			message.setSubject("LoginPortal Password Assistance");
			int otp1=Integer.parseInt(y);
			message.setText("Your OTP is: " +otp1+". Please donot share this with anyone");
			mailSender.send(message);
           otpSent=y;
			logger.info("succesfully sent otp");
			

		}

		if (c==choice3) {
			logger.debug("finding security questions of the user......");
		
			User u = new User();
			u.setEmailID(p.getEmail());
			System.out.println(u);
		 userurl = "http://localhost:8017/api/data/user/find";
			User l = resttemplate.postForObject(userurl, u, User.class);
			System.out.println(l);
			long q1 = l.getSecurityAns().getSecurityQueID1();
			long q2 = l.getSecurityAns().getSecurityQueID2();
			
			String url = "http://localhost:8017/api/data/security-question/find";

			SecurityQuestion[] list = resttemplate.getForObject(url,SecurityQuestion[].class);
		//	List<SecurityQuestion> al = al1.getSq();
			

			logger.debug("security questions retrieved successfully......");

			ArrayList<String> ll = new ArrayList<String>();
		
//			for(int i=0;i<al.size();i++) {
//				if(al.get(i).getQuestionID()==q1||al.get(i).getQuestionID()==q2)
//				{
//					ll.add(al.get(i).getQuestion());
//				}
//				
//			}
			
for(SecurityQuestion i:list)
{
	if(i.getQuestionID()==q1||i.getQuestionID()==q2) {
		ll.add(i.getQuestion());
	}
}
			
			

			jsonObject.put("question1", ll.get(0));

			jsonObject.put("question2", ll.get(1));
		}
		logger.debug(jsonLogInfo);
		return jsonObject.toString();

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/sec")
	public String security(@RequestBody Request p) {
		logger.info("checking the entered answers......");

		ObjectNode jsonObject = mapper.createObjectNode();
		if (securityQuestionsCheck(p)) {
			logger.info("Entered answers are correct......");
			jsonObject.put(status, tru);

		}

		else {
			logger.warn("Entered answers are Incorrect......");
			jsonObject.put(status, fal);

		}
		logger.debug(jsonLogInfo);
		return jsonObject.toString();

	}

	private boolean securityQuestionsCheck(Request p) {

		logger.debug("inside  securityQuestionsCheck......");

	
		
		

		User u = new User();
		u.setEmailID(p.getEmail());

		User l = resttemplate.postForObject(userurl, u, User.class);
		logger.debug("retrieving the answers given by the user......");
	
		System.out.println(l);
		String ans1 = l.getSecurityAns().getSecurityAnsID1();
		String ans2 = l.getSecurityAns().getSecurityAnsID2();

		logger.debug("Answers given by the users retrieved......");

		boolean st = false;
		if (ans1.equals(p.getAns1()) && ans2.equals(p.getAns2())) {
			logger.debug("succesfully validated the answers and sending back to called method......");

			st = true;
		} else {
			logger.debug("succesfully validated the answers and sending back to called method......");

		}
		return st;
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/set")
	public String setPassword(@RequestBody Request p) {

		ObjectNode jsonObject = mapper.createObjectNode();
		logger.info("Setting new password......");
		String pass = p.getPwd();
		System.out.println(pass);
		User u=new User();
		u.setEmailID(email);
		
		logger.debug("getting password from front end.....");
		
		logger.debug("retrieving the answers given by the user......");
		User l = resttemplate.postForObject(userurl, u, User.class);
		
		String pwd1 = l.getPasswordHistory().getPwd1();
		String pwd2 = l.getPasswordHistory().getPwd2();
		String pwd3 = l.getPasswordHistory().getPwd3();
		String salt1 = l.getPasswordHistory().getSalt1();
		String salt2 = l.getPasswordHistory().getSalt2();
		String salt3 = l.getPasswordHistory().getSalt3();
		logger.info("salt1 {}",salt1);
		logger.info("salt2 {}",salt2);

		logger.info("salt3 {}",salt3);

		String salt=BCrypt.gensalt(12);
		String hashedPassword = cpe.encodeWithSalt(pass, salt);
		if(salt1!=null&&salt2!=null&&salt3!=null)
		{
			
			
		
		 

		logger.debug("generating salt .....");
		
  
		logger.debug("generating hashed password .....");
		
		logger.debug("getting previous passwords from database.....");

		logger.debug("checking with the recent passwords.....");
		if (check(pass, salt1, pwd1) == false && check(pass, salt2, pwd2) == false
				&& check(pass, salt3, pwd3) == false)

		{
			System.out.println("1");

			logger.debug("shifting the column data  of passwords.....");
			l.getPasswordHistory().setPwd3(pwd2);
			l.getPasswordHistory().setPwd2(pwd1);
			l.getPasswordHistory().setPwd1(hashedPassword);
			l.getPasswordHistory().setSalt3(salt2);
			l.getPasswordHistory().setSalt2(salt1);
			l.getPasswordHistory().setSalt1(salt);
		}
		}
		else if(salt1==null)
		{
			System.out.println("2");
			logger.debug("shifting the column data  of passwords.....");
			l.getPasswordHistory().setPwd1(pass);
			l.getPasswordHistory().setSalt1(salt);
		}
		else if(salt2==null)
		{
			if(check(pass,salt1,pwd1)==false)
			{
				System.out.println("3");
				logger.debug("shifting the column data  of passwords.....");
				l.getPasswordHistory().setPwd2(pwd1);
				l.getPasswordHistory().setPwd1(hashedPassword);
				l.getPasswordHistory().setSalt2(salt1);
				l.getPasswordHistory().setSalt1(salt);
			}
		}
		
		else 
		{

			if(check(pass,salt1,pwd1)==false&&check(pass,salt2,pwd2))
			{
				logger.debug("shifting the column data  of passwords.....");
				l.getPasswordHistory().setPwd3(pwd2);
				l.getPasswordHistory().setPwd2(pwd1);
				l.getPasswordHistory().setPwd1(hashedPassword);
				l.getPasswordHistory().setSalt3(salt2);
				l.getPasswordHistory().setSalt2(salt1);
				l.getPasswordHistory().setSalt1(salt);
			}
		}
		
		System.out.println(l.getPasswordHistory());
		String	url = "http://localhost:8017//api/data/password-history/update";

			int al = resttemplate.postForObject(url, l.getPasswordHistory(), Integer.class);
			System.out.println(al);
			if (al == 1) {
				logger.info(" password succesfully set.....");
				jsonObject.put(status, tru);
			} else {
				logger.info(" password is not set succesfully.....");

				jsonObject.put(status, fal);
			}
			logger.debug(jsonLogInfo);
		
		return jsonObject.toString();
	}

	private boolean check(String pwd, String salt, String hashedPassword) {
		String hashedPassword1 = cpe.encodeWithSalt(pwd,salt);
		if (hashedPassword.equals(hashedPassword1))
			return true;

		return false;
	}
}
