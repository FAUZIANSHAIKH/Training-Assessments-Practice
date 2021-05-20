package com.sapient.productservice.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.sapient.productservice.model.Product;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/v1/products")
@EnableSwagger2
public class ProductController
{
	
	@Autowired
	ProductService employeeService;
	
	@GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value="fetch all employees", notes = "API to fetch all the employees")
	

	public List<Product> listAll()
	{
		List<Product> list=employeeService.fetchAllEmployees();
		//List<Product> products=Arrays.asList(new Product(), new Product(),new Product());
		return list;
	}
	
@GetMapping(value="/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
public Product findById(@ApiParam(value = "${ProductionController.FetchById")@PathVariable("id") int id)
{
	Product product=employeeService.findById(id);
	return product;
	
}
@PostMapping(value="/" , consumes = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
public Product saveProduct(  @RequestBody Product product)
{
	System.out.println("save");
	return employeeService.saveProduct(product);
	
		
}
@PutMapping(value ="/{id}" , consumes = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
public void updateProduct(@PathVariable int id,@RequestBody Product product)
{
	System.out.println("Update");
	product.setId(id);
	employeeService.updateProduct(id,product);
	
}
@DeleteMapping(value="/{id}")
public void deleteProduct(@PathVariable int id)
	{
	employeeService.deleteProduct(id);
	
	System.out.println("Deleted product Successfully");
	}
}