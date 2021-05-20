package com.sapient.productservice.service;

import com.sapient.productservice.model.Product;
import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    public List<Product> fetchAllEmployees();

    public Product findById(int id);

    public void deleteProduct(int id);
    public void updateProduct(int id,Product product);

}