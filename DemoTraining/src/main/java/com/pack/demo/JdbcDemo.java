package com.pack.demo;


import java.sql.*;
public class JdbcDemo
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Sapient123");
			Statement stmt=con.createStatement();
			//stmt.executeUpdate("Insert into emp values('Fauzia',21)");
			//stmt.executeUpdate("Insert into emp values('Jitendra',28)");
			//stmt.executeUpdate("Update emp set age=age+1");
			ResultSet rs=stmt.executeQuery("Select * from emp");
			while(rs.next())
			{
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Age: "+rs.getInt(2));
				System.out.println();
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}