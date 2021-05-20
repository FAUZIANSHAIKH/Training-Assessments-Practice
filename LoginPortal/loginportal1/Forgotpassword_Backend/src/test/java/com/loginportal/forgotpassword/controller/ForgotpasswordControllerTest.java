/*
 * package com.loginportal.forgotpassword.controller;
 * 
 * import static org.junit.Assert.*; import org.junit.Before;
 * 
 * import org.junit.Test; import org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * 
 * import com.loginportal.forgotpassword.model.Request; import
 * com.loginportal.forgotpassword.model.User;
 * 
 * public class ForgotpasswordControllerTest extends AbstractTestClass { String
 * email = "shaikneha823@gmail.com";
 * 
 * @Override
 * 
 * @Before public void setUp() { super.setUp(); }
 * 
 * @Test public void mailCheck() throws Exception {
 * 
 * String uri = "/forgotpassword/uic";
 * 
 * User person = new User();
 * 
 * person.setEmailID(email);
 * 
 * String inputJson = super.mapToJson(person);
 * 
 * MvcResult mvcResult = mvc.perform(
 * MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE
 * ).content(inputJson)) .andReturn();
 * 
 * MvcResult mvcResult =
 * mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.
 * APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus();
 * 
 * assertEquals(200, status);
 * 
 * String content = mvcResult.getResponse().getContentAsString();
 * 
 * assertEquals(content, "{\"status\":\"true\"}");
 * 
 * }
 * 
 * @Test
 * 
 * public void getChoice() throws Exception {
 * 
 * String uri = "/forgotpassword/mts";
 * 
 * Request person = new Request(); person.setEmail(email); person.setChoice(3);
 * 
 * String inputJson = super.mapToJson(person);
 * 
 * MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
 * 
 * .contentType(MediaType.APPLICATION_JSON_VALUE)
 * 
 * .content(inputJson)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus();
 * 
 * assertEquals(200, status);
 * 
 * String content = mvcResult.getResponse().getContentAsString();
 * 
 * assertEquals(content,
 * "{\"question1\":\"What is your favorite team?\",\"question2\":\"What is your favorite movie?\"}"
 * );
 * 
 * }
 * 
 * @Test
 * 
 * public void getSecurityQuestionsTest() throws Exception {
 * 
 * String uri = "/forgotpassword/sec";
 * 
 * Request person = new Request(); person.setEmail(email);
 * person.setAns2("pink");
 * 
 * person.setAns1("rcb");
 * 
 * String inputJson = super.mapToJson(person);
 * 
 * MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
 * 
 * .contentType(MediaType.APPLICATION_JSON_VALUE)
 * 
 * .content(inputJson)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus();
 * 
 * assertEquals(200, status);
 * 
 * String content = mvcResult.getResponse().getContentAsString();
 * 
 * assertEquals(content, "{\"status\":\"true\"}");
 * 
 * }
 * 
 * }
 */