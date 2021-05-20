package com.loginportal.register.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.loginportal.register.model.SecurityQuestion;
import com.loginportal.register.model.User;
import com.loginportal.register.service.SecurityQuestionService;
import com.loginportal.register.service.UserService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityQuestionService securityquestionService;
	@Autowired
	ObjectMapper mapper;

	@GetMapping(value = "/securityquestions")
	@ApiOperation(value = "${RegisterController.getsecurityquestions}")
	public List<SecurityQuestion> securityquestions() {

		return securityquestionService.findAll();
	}

	@GetMapping(value = "/getallusers")
	@ApiOperation(value = "${RegisterController.registerUser}")
	public List<User> getAllUsers() {
		System.out.println(new User());
		System.out.println("Inside getallusers");
		return userService.findAll();
	}

	@PostMapping(path = "/register")
	public ObjectNode saveProduct(@RequestBody User user) {

		ObjectNode objectNode = mapper.createObjectNode();
		try {
			User user2 = userService.saveUser(user);
			
			System.out.println(user2.getUserID());
			 objectNode.put("status", 200);
			 objectNode.put("userID", user2.getUserID());
			 objectNode.put("message", "User Successfully Registered");
			
		} catch (DataIntegrityViolationException e) {
			 objectNode.put("status", 406);
			 objectNode.put("message", "User Already Exists");
			
		} catch (Exception e) {
			 objectNode.put("status", 403);
			 objectNode.put("message", "Service Unavailable");			
		}
		return objectNode;
	}

}
