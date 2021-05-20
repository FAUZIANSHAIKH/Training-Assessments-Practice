package com.sapient.productservice.dao;

import com.sapient.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository(value = "mysqlDAOImpl")
public class MySQLProductDAOImpl implements ProductDAO {

//   @Autowired
    private JdbcTemplate jdbcTemplate;


    public MySQLProductDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public String save(Product product) {
        System.out.println("Came inside the save method of MySQLEmployeeDAOImpl");
        jdbcTemplate.execute("insert into product values ('"+product.getId()+"','"+product.getName()+"','"+product.getPrice()+"')");
        return "Success";
    }

    public List<Product> listAll() {
    	System.out.println("MYSQL DAO");
       List<Product> productList = jdbcTemplate.query("select * from product",
               ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3)));
       return productList;
    }

    public Product findById(int id) {
        return jdbcTemplate.queryForObject("select * from Product where id=" + id,
                (rs, rowNum) -> {
                   Product product =  new Product(rs.getInt(1), rs.getString(2),rs.getDouble(3));
                           //product.setAge(45);
                           return product;
                });

    }

    public void deleteProduct(int id) {
    	//System.out.println("&&&&&&&&&&"+id);
    	jdbcTemplate.update("delete from product where id="+id);
    }

	
	public void updateProduct(int id, Product product) 
	{	String updateQuery = "update product set id=?,name = ?,price=? where id = ?";
	System.out.println("in update");
	jdbcTemplate.update(updateQuery, product.getId(),product.getName(),product.getPrice(), id);
	}

	
}