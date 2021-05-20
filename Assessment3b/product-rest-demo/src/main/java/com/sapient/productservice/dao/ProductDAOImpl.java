package com.sapient.productservice.dao;

import com.sapient.productservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository(value="employeeDAO")
public class ProductDAOImpl implements ProductDAO {

    private static List<Product> products = new ArrayList<Product>();

    public String save(Product product) {
        products.add(product);
        return "Success";
    }

    public List<Product> listAll() {
        System.out.println("Inside the list all method of EmployeeDAO");

        return null;
    }

    public Product findById(int id) {
        System.out.println("Inside the findBYId method of EmployeeDAO");
        return null;
    }

    public void deleteProduct(int id) {
        System.out.println("inside the delete method of EmployeeDAO");
    }

	
	public void updateProduct(int id, Product product) {
		System.out.println("inside the update method of EmployeeDAO");
		
	}
}