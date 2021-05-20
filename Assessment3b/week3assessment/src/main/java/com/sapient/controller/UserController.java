package com.sapient.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import com.sapient.model.User;
import com.sapient.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.sapient.model.User;
import com.sapient.model.Address;
import com.sapient.model.Post;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/v1/products")
@EnableSwagger2
public class UserController {

	@Autowired
	UserService employeeService;

	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<User> listAll() {
		List<User> list = employeeService.fetchAllEmployees();
		// List<Product> products=Arrays.asList(new Product(), new Product(),new
		// Product());
		System.out.println("LIST ALL");
		return list;
	}

//	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	public User findById(@ApiParam(value = "${ProductionController.FetchById") @PathVariable("id") int id) {
//		User user = employeeService.findById(id);
//		return user;
//
//	}
//
	@PostMapping(value = "/", consumes = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody User user) {


		System.out.println("save");
		employeeService.saveUser(user);
	

	}

@PutMapping(value ="/{id}" , consumes = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
public void updateUser(@PathVariable int id,@RequestBody User user)
{
	System.out.println("Update");
	user.setId(id);
	employeeService.updateUser(id,user);
	
}
	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable int id) {
		employeeService.deleteUser(id);
		System.out.println("Deleted user Successfully");
	}
//
	@GetMapping(value = "/list")
	public List<Post> listAllPost() {
		List<Post> list = employeeService.listAllPost();
		
		// List<Product> products=Arrays.asList(new Product(), new Product(),new
		// Product());
		System.out.println("LIST ALL");
		return list;
	}

	@GetMapping(value = "/findById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Post> findPostById(@ApiParam(value = "${ProductionController.FetchById") @PathVariable("id") int id)
	{
		List<Post> post = employeeService.findPostById(id);
		return post;
	}


//	}
//
	@PostMapping(value = "/post", consumes = { APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE })
	public void savePost(@RequestBody Post post) {
		System.out.println("save");
		employeeService.savePost(post);

	}

//@PutMapping(value ="/{id}" , consumes = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
//public void updatePost(@PathVariable int id,@RequestBody User user)
//{
//System.out.println("Update");
//
//employeeService.updateUser(id,post);


	@DeleteMapping(value = "/post/{id}")
	public void deletePostById(@PathVariable int id) {
		System.out.println("Deleted post Successfully");
		employeeService.deletePostById(id);


	}

	@DeleteMapping(value = "/")
	public void deletePost() {
		employeeService.deletePost();
		System.out.println("Deleted posts Successfully");
	}

}