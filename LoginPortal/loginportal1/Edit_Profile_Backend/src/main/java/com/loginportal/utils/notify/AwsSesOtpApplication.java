package com.loginportal.utils.notify;


//import org.springframework.beans.factory.annotation.Autowired;

/*import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;*/


public class AwsSesOtpApplication {
	
	/*
	 * private String to; private String from; private String subject; private
	 * String text; public Integer generatedOtp;
	 * 
	 * @Autowired static AWSCredentialsProvider credentialsProvider;
	 * 
	 * 
	 * 
	 * public String getTo() { return to; }
	 * 
	 * 
	 * public void setTo(String to) { this.to = to; }
	 * 
	 * 
	 * public String getFrom() { return from; }
	 * 
	 * 
	 * public void setFrom(String from) { this.from = from; }
	 * 
	 * 
	 * public String getSubject() { return subject; }
	 * 
	 * 
	 * public String getText() { return text; } public Integer getOtp() { return
	 * this.generatedOtp; }
	 * 
	 * @Autowired public AwsSesOtpApplication() { System.out.println("constructor");
	 * }
	 * 
	 * 
	 * public void doSendEmailWith(String to) { final String FROM =
	 * "maitreyee.gadwe@publicissapient.com"; Integer otp = (int)((Math.random() *
	 * (10000 - 1000)) + 1000); this.generatedOtp = otp; final String SUBJECT =
	 * "LoginPortal Update Profile Assistance"; final String HTMLBODY =
	 * "Your OTP is: " + otp+" please donot share this with anyone."; final String
	 * TEXTBODY = "This email was sent through Amazon SES " +
	 * "using the AWS SDK for Java.";
	 * 
	 * try { AmazonSimpleEmailService client =
	 * AmazonSimpleEmailServiceClientBuilder.standard()
	 * .withRegion(Regions.US_EAST_1).build(); SendEmailRequest request = new
	 * SendEmailRequest() .withDestination( new Destination().withToAddresses(to))
	 * .withMessage(new Message() .withBody(new Body() .withHtml(new Content()
	 * .withCharset("UTF-8").withData(HTMLBODY)) .withText(new Content()
	 * .withCharset("UTF-8").withData(TEXTBODY))) .withSubject(new Content()
	 * .withCharset("UTF-8").withData(SUBJECT))) .withSource(FROM);
	 * client.sendEmail(request);
	 * //sendCustomVerificationEmail(sendCustomVerificationEmailRequest);
	 * //sendEmail(request); System.out.println("Email sent!"); } catch (Exception
	 * ex) { System.out.println("The email was not sent. Error message: " +
	 * ex.getMessage()); }
	 * 
	 * }
	 * 
	 * 
	 * public void setSubject(String subject) { this.subject = subject; }
	 * 
	 * 
	 * public void setText(String text) { this.text = text; }
	 */
}
