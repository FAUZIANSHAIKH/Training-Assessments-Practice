package com.loginportal.deregister;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.loginportal.deregister.controller.DeRegisterController;
import com.loginportal.deregister.model.User;
import com.loginportal.deregister.service.DeRegisterService;
import com.loginportal.deregister.model.Authenticate;
import com.loginportal.deregister.model.Deactivate;
import com.loginportal.deregister.model.PasswordHistory;
import com.loginportal.deregister.model.Review;
import com.loginportal.deregister.model.SecurityAnswer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeRegisterControllerTests extends AbstractTest{

	@InjectMocks 
	DeRegisterController deRegisterController;
	
	@MockBean
	DeRegisterService deRegisterService;
	
	Authenticate authenticate = new Authenticate();
	Deactivate deactivateUser = new Deactivate();
	List<Review> reviews = new ArrayList<Review>();
	 Review r = new Review();
	User user = new User();
	  
    PasswordHistory password= new PasswordHistory();
    SecurityAnswer securityAns= new SecurityAnswer();
    
    Date date = new Date();	
    private Timestamp time = new Timestamp(date.getTime());
	
    @Before
	public void setup() {
		super.setUp();
	    
		authenticate.setUserId(1);
		authenticate.setPassword("xyz");
		deactivateUser.setUserId((long)1);
		 password.setPwd1("pavani@23");
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
	       r.setUserid(1);
	       r.setFirstName("Riya");
	       r.setReview("Quite good product");
	       r.setReviewid(1);
	     
		
	}
	
	@Test
	public void testdeactivateUser() throws Exception{
		 String uri = "/api/v1/users/deactivate";
		
		 
		 //case 1:deactivation done successfully
	     Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(user);
	     Mockito.when(deRegisterService.updateUserStatus(user)).thenReturn(true);
	     Mockito.when(deRegisterService.deactivateUser(authenticate)).thenReturn(deactivateUser);
	     String inputJson = super.mapToJson(authenticate);
	     MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
   		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
	     String content = mvcResult.getResponse().getContentAsString();
	    assertEquals("{\"status\":200,\"message\":\"Success\"}",content);
	    
	    //case 2: user doesn't exist
	    Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(null);
	   inputJson = super.mapToJson(authenticate);
	   mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
  		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
	    content = mvcResult.getResponse().getContentAsString();
	    assertEquals("{\"status\":400,\"message\":\"Wrong credentials\"}",content);
	      
	    //case 3:When user status can't be updated 
	    Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(user);
	    Mockito.when(deRegisterService.updateUserStatus(user)).thenReturn(false);
		   inputJson = super.mapToJson(authenticate);
		   mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	  		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
		    content = mvcResult.getResponse().getContentAsString();
		    assertEquals("{\"status\":301,\"message\":\"DbError\"}",content);
		    
		//case 4: When entry can't be made into deactivation table
		   Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(user);
		   Mockito.when(deRegisterService.updateUserStatus(user)).thenReturn(true);  
		   Mockito.when(deRegisterService.deactivateUser(authenticate)).thenReturn(null);
		   inputJson = super.mapToJson(authenticate);
		   mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	  		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
		    content = mvcResult.getResponse().getContentAsString();
		    assertEquals("{\"status\":301,\"message\":\"DbError\"}",content);
		    
		  //case 4: When entry can't be made into deactivation table
			   Mockito.when(deRegisterService.authenticateUser(authenticate)).thenThrow(NoSuchElementException.class);
			   inputJson = super.mapToJson(authenticate);
			   mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		  		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
			    content = mvcResult.getResponse().getContentAsString();
			    assertEquals("{\"status\":400,\"message\":\"Wrong credentials\"}",content);
	    
	}
//	
	@Test
	public void testforgetUser() throws Exception{
		 String uri = "/api/v1/users/forgetuser";
	    
	    //case 1: user doesn't exist
	      Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(null);
	   String inputJson = super.mapToJson(authenticate);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
  		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
	    String content = mvcResult.getResponse().getContentAsString();
	    assertEquals("{\"status\":400,\"message\":\"Wrong credentials\"}",content); 
	      
	    //case 2:When user status can't be updated 
	    Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(user);
	    Mockito.when(deRegisterService.forgetUser(user)).thenReturn(false);
		   inputJson = super.mapToJson(authenticate);
		   mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	  		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
		    content = mvcResult.getResponse().getContentAsString();
		    assertEquals("{\"status\":301,\"message\":\"DbError\"}",content); 
		    
		    //case 3:forgetUser done successfully
		    Mockito.when(deRegisterService.authenticateUser(authenticate)).thenReturn(user);
		     Mockito.when(deRegisterService.forgetUser(user)).thenReturn(true);
		    inputJson = super.mapToJson(authenticate);
		    mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	   		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(); 
		   content = mvcResult.getResponse().getContentAsString();
		    assertEquals("{\"status\":200,\"message\":\"Success\"}",content); 
		
	    
	}
	
	@Test
	public void testReviews() throws Exception {
		String uri = "/api/v1/users/getreviews";
		
		  Mockito.when(deRegisterService.getComments()).thenReturn(reviews);
	       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	    		   .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	       
	       //CASE 1 empty list is returned
	       String content = mvcResult.getResponse().getContentAsString();
	       Review[] reviewList =mapFromJson(content,Review[].class);
	       assertTrue(reviewList.length ==0);
	       
    
	       //CASE 2 list is returned
	       reviews.add(r);
	       Mockito.when(deRegisterService.getComments()).thenReturn(reviews);
	       mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	    		   .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      content = mvcResult.getResponse().getContentAsString();
	      reviewList =mapFromJson(content,Review[].class);
	       assertTrue(reviewList.length >0);
	}
	
	
}
