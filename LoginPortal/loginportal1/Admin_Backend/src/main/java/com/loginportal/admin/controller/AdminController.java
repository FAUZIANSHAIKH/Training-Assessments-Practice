package com.loginportal.admin.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.loginportal.admin.model.ActiveUsers;
import com.loginportal.admin.model.User;

import com.utils.logging.UserLogs;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	
	 
	@Autowired
	private RestTemplate restTemplate;
	 UserLogs logging  = new UserLogs();
	@GetMapping(value = "/getAll")
	public ResponseEntity<Iterable<User>> findAll() {
		
		String url = "http://localhost:8017/api/data/user/get-users";
		List <User> list=null;
		try {
			list = restTemplate.getForObject(url, List.class);
			logging.logInfo("Fetched details of users", 213, "97.125.43.151", "Chrome");
			
		}
		catch(Exception e) {
			logging.logError("Could not fetch details", 461, "GetMapping", "97.125.43.151", "Chrome");
		}
		logging.logMethodExitTrace("Exiting UpdateUser Method",213,"POST","199.200.999.000", "HP Envy 360");
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/getAllActiveUsers")
	public ResponseEntity <Iterable<ActiveUsers>> findAllActiveUsers() {

		logging.logMethodEntryTrace("Fetching Active users list", 209, "GetMapping", "97.125.43.151", "Chrome");
		String url = "http://localhost:8017/api/data/active-user/findall";
		List <ActiveUsers> list=new ArrayList<ActiveUsers>();
		User user = new User();
		try {
			System.out.println("entered");
			list.addAll(restTemplate.postForObject(url, user, List.class));
			System.out.println("completed");
			//list = restTemplate.getForObject(url, List.class);
			logging.logInfo("Fetched details of users", 213, "97.125.43.151", "Chrome");
			
		}
		catch(Exception e) {
			logging.logError("Could not fetch details", 461, "GetMapping", "97.125.43.151", "Chrome");
		}
		return ResponseEntity.ok().body(list);	
	}

}