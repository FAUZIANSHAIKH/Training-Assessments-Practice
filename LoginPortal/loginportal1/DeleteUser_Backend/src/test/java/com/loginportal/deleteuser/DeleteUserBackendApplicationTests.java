package com.loginportal.deleteuser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.loginportal.deleteuser.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteUserBackendApplicationTests extends AbstractClassJunit{

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }

	  
	@Test
	public void undeleteUser() throws Exception{
		
		String uri = "/undeleteuser/";
	   User user = new User();
	   user.setUserID((long)1);
	   
	   
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "true");
	}
	
	@Test
	public void deleteUser() throws Exception{
		
		String uri = "/deleteuser/";
	   User user = new User();
	   user.setUserID((long)1);
	   
	   
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "true");
	}
	
	@Test
	public void purgeUser() throws Exception{
		
		String uri = "/purgeuser/";
	   User user = new User();
	   user.setUserID((long)1);
	   
	   
	   String inputJson = super.mapToJson(user);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(content, "true");
	}
	
}
