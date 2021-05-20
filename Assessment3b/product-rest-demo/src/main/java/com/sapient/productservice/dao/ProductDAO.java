package com.sapient.productservice.dao;

import com.sapient.productservice.model.Product;
import java.util.List;

public interface ProductDAO {

    public String save(Product product);

    public List<Product> listAll();

    public Product findById(int id);

    public void deleteProduct(int id);
    public void updateProduct(int id,Product product);

}