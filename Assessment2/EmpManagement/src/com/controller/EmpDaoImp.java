package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class EmpDaoImp implements InterfaceEmpDAO
{

	
	public boolean insert(Beans b) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Sapient123");
			PreparedStatement stmt=con.prepareStatement("insert into emp(id,name,salary,address,role) values(?,?,?,?,?)");  
			stmt.setInt(1,b.getId());
			stmt.setString(2,b.getName()); 
			stmt.setInt(3,b.getSalary());
			stmt.setString(4,b.getAddress()); 
			stmt.setString(5,b.getRole()); 
			stmt.execute();  
			System.out.println("Successfully inserted");  
			stmt.close();
			return true;
			
		}
			
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return false;
		
	}

	@Override
	public ArrayList<Beans> display() 
	{
		ArrayList<Beans> list=new ArrayList<Beans>();
		PreparedStatement stmt=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Sapient123");
			stmt=con.prepareStatement("select * from emp");  
			
			
		
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next())
			{
				Beans b=new Beans();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setSalary(rs.getInt(3));
				b.setAddress(rs.getString(4));
				b.setRole(rs.getString(5));
				list.add(b);
				
				
			}
			
			
			stmt.close();
		}
			
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return list;
		
	}

	@Override
	public boolean update(Beans b) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Sapient123");
			PreparedStatement stmt=con.prepareStatement("update emp set salary= ?,address= ?,role= ? where id=?");  
			stmt.setInt(1,b.getSalary());
			stmt.setString(2,b.getAddress());
			stmt.setString(3,b.getRole());
			stmt.setInt(4,b.getId());
			stmt.executeUpdate();  
			System.out.println("Updated");  
			stmt.close();
			return true;
			
		}
			
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean delete(Beans b) {
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Sapient123");
			PreparedStatement stmt=con.prepareStatement("delete from emp where id=?");  
			stmt.setInt(1,b.getId());
			
			stmt.execute();  
			System.out.println("Deleted");  
			stmt.close();
			return true;
			
		}
			
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Beans getUser(int id) {
		Statement stmt=null;
		Beans b=new Beans();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Sapient123");
			stmt=con.createStatement();  
			System.out.println("123");
			ResultSet rs=stmt.executeQuery("select * from emp where id="+id);
			while(rs.next())
			{
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			b.setSalary(rs.getInt(3));
			b.setAddress(rs.getString(4));
			b.setRole(rs.getString(5));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return b;
	}
	

}
