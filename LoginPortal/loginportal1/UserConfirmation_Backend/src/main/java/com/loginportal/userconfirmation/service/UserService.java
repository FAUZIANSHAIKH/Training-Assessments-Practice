package com.loginportal.userconfirmation.service;


import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.loginportal.userconfirmation.UserConfirmation;
import com.loginportal.userconfirmation.model.User;
import com.loginportal.userconfirmation.AwsSesOtpApplication;

@Service
public class UserService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private MailSender mailSender;
	 
	public User findById(long id) {
		User r = new User();
		r.setUserID(id);
		String url = "http://localhost:8017/api/data/user/find";
	    HttpEntity<User> httpEntity = new HttpEntity<>(r);
	    ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
	                new ParameterizedTypeReference<Optional<User>>() {});
		//Optional<User> user=employeeRepository.findById(id);
	    Optional<User> user = response.getBody();
	    if(user.isPresent())
			return user.get();
		else return null;
	}
	
//	public User findByEmailId(String id) {
//		return employeeRepository.findByEmailId(id);
//	}
	
	public User save(User r) {
		String url = "http://localhost:8017/api/data/user/update-account-status";
	    HttpEntity<User> httpEntity = new HttpEntity<>(r);
	    ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
	                new ParameterizedTypeReference<Integer>() {});
	    if(response.getBody() == 1) {
	    	return r;
	    }
	    else {
	    	return null;
	    }
	}
	
//	public void sendEmail(String email, long uid) throws MessagingException {
//		MimeMessage msg = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//		helper.setTo(email);
//        helper.setSubject("Account Activation Link");
//        String url = "http://localhost:8882/confirmmail/" + uid;
//        helper.setText("<h1>Click on the following link to activate your account :</h1>" + url, true);
//        javaMailSender.send(msg);
//	}
	
	public void sendEmailWithSES(Long uid, String to) {
		
		  // Replace sender@example.com with your "From" address.
		  // This address must be verified with Amazon SES.
		  final String FROM = "sanket.giri@publicissapient.com";

		  // Replace recipient@example.com with a "To" address. If your account
		  // is still in the sandbox, this address must be verified.
		  //final String TO = "sanket.giri@publicissapient.com";

		  // The configuration set to use for this email. If you do not want to use a
		  // configuration set, comment the following variable and the 
		  // .withConfigurationSetName(CONFIGSET); argument below.
		  //static final String CONFIGSET = "ConfigSet";

		  // The subject line for the email.
		  final String SUBJECT = "Account Confirmation Link";
		  
		  String url = "http://localhost:8006/#/confirmmail/" + uid;
		  // The HTML body for the email.
		  final String HTMLBODY = "<h1>Click on the following link to activate your account :</h1>" + "<a href='" + url + "'>" + url + "</a>";

		  // The email body for recipients with non-HTML email clients.
		  final String TEXTBODY = "This email was sent through Amazon SES "
		      + "using the AWS SDK for Java.";
		  
		try {
		      AmazonSimpleEmailService client = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
		          // Replace US_WEST_2 with the AWS Region you're using for
		          // Amazon SES.
		            .withRegion(Regions.US_EAST_1).build();
//		      SendCustomVerificationEmailRequest sendCustomVerificationEmailRequest = new SendCustomVerificationEmailRequest()
		      	SendEmailRequest request = new SendEmailRequest()
//		    		.withEmailAddress(TO)
//		    		.withTemplateName("SampleTemplate");
		          .withDestination(
		              new Destination().withToAddresses(to))
		          .withMessage(new Message()
		              .withBody(new Body()
		                  .withHtml(new Content()
		                      .withCharset("UTF-8").withData(HTMLBODY))
		                  .withText(new Content()
		                      .withCharset("UTF-8").withData(TEXTBODY)))
		              .withSubject(new Content()
		                  .withCharset("UTF-8").withData(SUBJECT)))
		          .withSource(FROM);
		          // Comment or remove the next line if you are not using a
		          // configuration set
		          //.withConfigurationSetName(CONFIGSET);
		      client.sendEmail(request); //sendCustomVerificationEmail(sendCustomVerificationEmailRequest); //sendEmail(request);
		      System.out.println("Email sent!");
		    } catch (Exception ex) {
		      System.out.println("The email was not sent. Error message: " 
		          + ex.getMessage());
		    }
	
	}
	
	public void awsSES(Long uid) {
		
		AwsSesOtpApplication mail =new AwsSesOtpApplication();
		mail.setFrom("sanket.giri@publicissapient.com");
		mail.setTo("sanket.giri@publicissapient.com");
		mail.setSubject("Account Activation Link");
		String url = "http://localhost:8001/confirmmail/" + uid;
		mail.setText("Click on the following link to activate your account : " + url);
		mail.doSendEmailWith();
		
//		SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("sanket.giri@publicissapient.com");
//        message.setTo("sanket.giri@publicissapient.com");
//        Double x=((Math.random()*(10000-1000))+1000);
//        String y=Double.toString(x);
//        message.setSubject("Hello from Sapient");
//        message.setText(y);
//        mailSender.send(message);
//        System.out.println("Message Sent");
	}
}
