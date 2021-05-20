package com.pack.demo;
import java.sql.*;
import java.util.Scanner;
public class JdbcDemo1
{
	public static void main(String args[])
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Sapient123");
			PreparedStatement pstmt=con.prepareStatement("Insert into emp values(?,?)");
			System.out.println("Enter Name ");
			String name=sc.next();
			System.out.println("Enter age ");
			int age=sc.nextInt();
			pstmt.setString(1, name);
			pstmt.setInt(2,age);
			pstmt.execute();
			pstmt.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}