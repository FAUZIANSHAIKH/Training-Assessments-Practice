package com.sapient.productservice.service;

import com.sapient.productservice.dao.ProductDAO;
import com.sapient.productservice.model.Product;
import com.sapient.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service(value = "employeeService")
public class ProductServiceImpl implements ProductService {

    @Autowired( required = true)
    @Qualifier(value = "HybernateDAOImpl")
    private ProductDAO productDAO;
    
    @Autowired
    private ProductRepository productRepository;
    
    public ProductServiceImpl(@Qualifier(value="JPIRepository")ProductRepository productRepository)
    {
    	this.productRepository=productRepository;
    }
    
    @Transactional
    public Product saveProduct(Product product) {
        System.out.println("Inside the save employee method of Employee service class ....");
        
        return productRepository.save(product);
    }
    @Transactional
    public List<Product> fetchAllEmployees() {
    	System.out.println("MYSQL Service");
        return (List<Product>) productRepository.findAll();
    }
    
    @Transactional
    public Product findById(int id) {
    	Optional<Product> optionalProduct=productRepository.findById(id);
    	if(optionalProduct.isPresent())
    	{
    		return optionalProduct.get();
    	}
        return null;
    }
    @Transactional
    public void deleteProduct(int id) {
    	productRepository.deleteById(id);
    }

    @Transactional
	public void updateProduct(int id, Product product) {
    	Optional<Product> optionalProduct=productRepository.findById(id);
    	if(optionalProduct.isPresent())
    	{
    		Product currProd= optionalProduct.get();
    		currProd.setId(product.getId());
    		currProd.setName(product.getName());
    		currProd.setPrice(product.getPrice());
    		productRepository.save(currProd);
    	}
       
//		System.out.println(product.getName());
//		productRepository.save(product);
		
	}
	
	
}