package com.loginportal.deleteuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginportal.deleteuser.service.AdminActionService;
import com.loginportal.deleteuser.model.AccountStatus;
import com.loginportal.deleteuser.model.User;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminActionController {
	
	@Autowired
	AdminActionService actionService;
	

	@ApiOperation("set status to delete")
	@PostMapping("/deleteuser/")
    public boolean deleteuser(@RequestBody User user)
    {
        long userId = user.getUserID();
    
        return actionService.performAction(AccountStatus.DELETE, userId);
    }
	
	@PostMapping("/undeleteuser/")
    public boolean undeleteuser(@RequestBody User user)
    {
		long userId = user.getUserID();
        return actionService.performAction(AccountStatus.ACTIVE, userId);
    }
	
	@PostMapping("/purgeuser/")
    public boolean purgeuser(@RequestBody User user)
    {
		long userId = user.getUserID();
        return actionService.performAction(AccountStatus.PURGE, userId);
    }
	
	@GetMapping(value = "/getAll")
    public ResponseEntity<Iterable<User>> findAll() {
        Iterable<User> u1 = actionService.findAll();
        return ResponseEntity.ok().body(u1);
	}
}
