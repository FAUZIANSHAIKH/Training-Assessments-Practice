package com.loginportal.userconfirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceMailSender;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

//@SpringBootApplication
//@Configuration
public class AwsSesOtpApplication {
	
	private String to;
	private String from;
	private String subject;
	private String text;
	
    @Autowired
	static
    AWSCredentialsProvider credentialsProvider;
    
	
	
	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getSubject() {
		return subject;
	}


	public String getText() {
		return text;
	}

	@Autowired
	public AwsSesOtpApplication() {
		System.out.println("constructor");
	}

	
	/*
	 * public static void main(String[] args) { System.out.println("hai");
	 * //ConfigurableApplicationContext context =
	 * SpringApplication.run(AwsSesOtpApplication.class, args);
	 * System.out.println("hai after"); try { doSendEmailWith(); } finally {
	 * 
	 * } }
	 */

	public void doSendEmailWith() {
		SimpleMailMessage message = new SimpleMailMessage();

		System.out.println("akash");
		MailSender sender = new SimpleEmailServiceMailSender(AmazonSimpleEmailServiceClientBuilder.standard()
                .withCredentials(credentialsProvider)
                // Replace US_WEST_2 with the AWS Region you're using for
                // Amazon SES.
                .withRegion(Regions.US_EAST_1).build());
	 
		Integer x = (int)((Math.random() * (10000 - 1000)) + 1000);
		String y = Integer.toString(x);
		message.setSubject(subject);
		message.setText(text);
		message.setTo(to);
		message.setFrom(from);
		
		sender.send(message);
		System.out.println("Message Sent");
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public void setText(String text) {
		this.text = text;
	}

}
