package com.loginportal.deregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.loginportal.deregister.model.Authenticate;
import com.loginportal.deregister.model.Deactivate;
import com.loginportal.deregister.model.User;
import com.loginportal.deregister.model.Review;
import com.loginportal.deregister.service.DeRegisterService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/users")
@PropertySource("classpath:documentation.properties")
public class DeRegisterController {

	
	public DeRegisterController() {
		
	}

	@Autowired
	private DeRegisterService deRegisterService;

	@Autowired
	ObjectMapper mapper;

	

	@GetMapping("/getreviews")
	 @ApiOperation(value = "${DeRegisterController.getReviews}",notes= "${DeRegisterController.getReviews}")
	public List<Review> listofreviews() {
		return deRegisterService.getComments();
	}

	@PostMapping(value = "/deactivate")
	@ApiOperation(value = "${DeRegisterController.deactivateUser}")
	public ObjectNode deactivateUser(@RequestBody Authenticate authenticate) throws Exception {
		ObjectNode objectNode = mapper.createObjectNode();
		try {
			User user = deRegisterService.authenticateUser(authenticate);
			if (user != null) {
				Boolean updateStatus = deRegisterService.updateUserStatus(user);

				if (updateStatus) {
					deRegisterService.changeNameInReviews(user);
					Deactivate deactivateUser = deRegisterService.deactivateUser(authenticate);
					if (deactivateUser != null) {
						objectNode.put("status", 200);
						objectNode.put("message", "Success");
					} else {
						objectNode.put("status", 301);
						objectNode.put("message", "DbError");
					}
				} else {
					objectNode.put("status", 301);
					objectNode.put("message", "DbError");
				}
			} else {
				objectNode.put("status", 400);
				objectNode.put("message", "Wrong credentials");
			}
		} catch (Exception e) {
			objectNode.put("status", 400);
			objectNode.put("message", "Wrong credentials");
		}

		return objectNode;

	}

	@PostMapping(value = "/forgetuser")
	@ApiOperation(value = "${DeRegisterController.forgetUser}")
	public ObjectNode forgetUser(@RequestBody Authenticate authenticate) throws Exception {
		ObjectNode objectNode = mapper.createObjectNode();

		try {
			User user = deRegisterService.authenticateUser(authenticate);
			if (user != null) {
				Boolean forgetStatus = deRegisterService.forgetUser(user);
				if (forgetStatus) {
					deRegisterService.deleteInReviews(user);

					objectNode.put("status", 200);
					objectNode.put("message", "Success");

				} else {
					objectNode.put("status", 301);
					objectNode.put("message", "DbError");
				}
			} else {
				objectNode.put("status", 400);
				objectNode.put("message", "Wrong credentials");
			}
		} catch (Exception e) {
			objectNode.put("status", 400);
			objectNode.put("message", "Wrong credentials");
		}

		return objectNode;

	}
}
