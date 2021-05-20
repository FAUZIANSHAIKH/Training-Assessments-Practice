package com.loginportal.deregister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.datatype.jdk8.OptionalDoubleSerializer;
import com.loginportal.deregister.model.Authenticate;
import com.loginportal.deregister.model.Deactivate;
import com.loginportal.deregister.model.PasswordHistory;
import com.loginportal.deregister.model.Review;
import com.loginportal.deregister.model.SecurityAnswer;
import com.loginportal.deregister.model.User;
import com.loginportal.deregister.repository.AuthenticateRepository;
import com.loginportal.deregister.repository.DeactivateRepository;
import com.loginportal.deregister.repository.ReviewRepository;
import com.loginportal.deregister.service.DeRegisterService;
import com.loginportal.deregister.service.DeRegisterServiceImpl;

import java.util.Optional;

import com.loginportal.deregister.model.CustomPasswordEncoder;


@RunWith(SpringRunner.class)
public class DeRegisterServiceTests {
	
//	@MockBean
//	@Qualifier(value="authenticateRepository")
//	AuthenticateRepository authenticateRepository;
//	
//	@MockBean
//	@Qualifier(value="deactivateRepository")
//	DeactivateRepository deactivateRepository;
//	
//	@MockBean
//	@Qualifier(value="reviewRepository")
//	ReviewRepository reviewRepository;
//	
	@MockBean 
	CustomPasswordEncoder custompasswordencoder;
	
	@Autowired
	DeRegisterService deRegisterService;
	
	@MockBean
	RestTemplate restTemplate;
	
	Deactivate deActivateUser = new Deactivate();
	Authenticate authenticate = new Authenticate();
	Deactivate deactivateUser = new Deactivate();
	Review[] reviewList;
	Review review = new Review();
	User user = new User();
	Optional<User> newUser;
	PasswordHistory password= new PasswordHistory();
    SecurityAnswer securityAns= new SecurityAnswer();
    Date date = new Date();	
    private Timestamp time = new Timestamp(date.getTime());
	
	  @TestConfiguration
	    static class DataServiceTestContextConfiguration {
	        @Bean
	        public DeRegisterService deRegisterService() {
	            return new DeRegisterServiceImpl();
	        }
	    }
	  
	@Before
	public void setup() {
		authenticate.setUserId(1);
		deActivateUser.setUserId((long) 10);
		 password.setPwd1("$12$VxhP0iN6u9dICx8TD8Ja9OedPSDTGbqEMuWtk2AB53fAwchWPkUUm");
	       securityAns.setSecurityQueID1(1);
	       securityAns.setSecurityAnsID1("CTC");
	       securityAns.setSecurityQueID2(2);
	       securityAns.setSecurityAnsID2("DDLJ");
	       user.setFirstName("Pavani");
	       user.setLastName("Nemuri");
	       user.setEmailID("pavanjktteinemeeuri8@gmail.com");
	       user.setPhoneNo("1234567891");
	       user.setPasswordHistory(password);
	       user.setSecurityAns(securityAns);
	       user.setAccountCreationTime(time);
	       review.setUserid(1);
	       review.setFirstName("Riya");
	       review.setReview("Quite good product");
	       review.setReviewid(1);
	}
//	
////	@Test
////	public void testdeactivateUser() {
////		Mockito.when(deactivateRepository.save(deActivateUser)).thenReturn(deActivateUser);
////		Deactivation deActivateUser1 = deRegisterService.deactivateUser(authenticate);
////		System.out.println("heyyy");
////		System.out.println(deActivateUser);
////		System.out.println(deActivateUser1);
////		assertEquals(deActivateUser1, deActivateUser);
////	}
//	
//	@Test
//	public void testUpdateUserStatus() throws Exception {
//		
//		String url = "http://localhost:8017/api/data/user/update-account-status";
//		
//		//Status is updated correctly
//		Mockito.when(authenticateRepository.save(user)).thenReturn(user);
//		boolean updateStatus = deRegisterService.updateUserStatus(user);
//		assertTrue(updateStatus);
//		
//		//Unable to update Status
//		Mockito.when(authenticateRepository.save(user)).thenReturn(null);
//		updateStatus = deRegisterService.updateUserStatus(user);
//		assertFalse(updateStatus);
//	}
	
//	@Test
//	public void testAuthenticateUser() throws Exception {
//	
//     
//	
////     Case 1:Null is returned
//     Mockito.when(authenticateRepository.findById(authenticate.getUserId()))
//								.thenReturn(newUser);
//		User validUser = deRegisterService.authenticateUser(authenticate);
//		assertEquals(validUser, newUser);
//		
//	//Case 2 : User is returned
////		newUser = Optional.of(user);
////		 System.out.println(newUser);
////	Mockito.when(custompasswordencoder.encodeWithSalt(Mockito.any(String.class),Mockito.any(String.class))).thenReturn("$12$VxhP0iN6u9dICx8TD8Ja9OedPSDTGbqEMuWtk2AB53fAwchWPkUUm");
////			
////		 Mockito.when(authenticateRepository.findById(authenticate.getUserId()))
////			.thenReturn(newUser);
////		 System.out.println(newUser);
////		User validUser = deRegisterService.authenticateUser(authenticate);
////		 assertEquals(validUser, newUser);
//	}
	
	@Test
	public void testgetComments() {
		//Case 1 empty List is returned
		String url = "http://localhost:8017/api/data/review/findAll";
		
		Mockito.when(restTemplate.getForObject(url, Review[].class)).thenReturn(reviewList);
		List<Review> newReviews = deRegisterService.getComments();
		assertTrue(newReviews.size() == 0);
		
//		Case 2 Reviews list is returned
		reviewList= new Review[2];
		reviewList[0]=review;
		Mockito.when(restTemplate.getForObject(url, Review[].class)).thenReturn(reviewList);
		newReviews = deRegisterService.getComments();
		assertTrue(newReviews.size() > 0);
		
	
	}
}
