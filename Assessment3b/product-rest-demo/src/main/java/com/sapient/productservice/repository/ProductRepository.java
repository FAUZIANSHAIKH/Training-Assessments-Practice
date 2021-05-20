package com.sapient.productservice.repository;
import org.springframework.data.repository.CrudRepository;
import com.sapient.productservice.model.Product;
import org.springframework.stereotype.Repository;
@Repository(value="JPIRepository")
public interface ProductRepository extends CrudRepository<Product,Integer> 
{

}
