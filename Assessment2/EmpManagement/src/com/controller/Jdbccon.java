package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
public class Jdbccon 
{
	public boolean check(String name,String pass)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root","Sapient123");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from emp where name='"+name+"'");
			rs.next();
			if(rs!=null)
			{
			if(rs.getString(6).equals(pass) && rs.getString(5).equals("admin"))
				return true;
			else {
				return false;
			}
			}
			
		}
			
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return false;
	}
	
}
