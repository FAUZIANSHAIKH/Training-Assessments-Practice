package com.example.demo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class MsAuthenticationServiceApplication {

public static void main(String[] args) {
SpringApplication.run(MsAuthenticationServiceApplication.class, args);
}
@RequestMapping("/fetch")
public String demoMethod(@RequestBody UserDAO user)
{
String name=user.getName();
String pass=user.getPassword();
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assess","root","Sapient123");
Statement stmt1=con.createStatement();
PrintWriter pw=new PrintWriter(System.out);
ResultSet rs=stmt1.executeQuery("select * from login");
while(rs.next())
{
String nam1=rs.getString(1);
String nam2=rs.getString(2);
if(nam1.equals(name) && nam2.equals(pass)) {

return "true";
}
}

}
catch(Exception e)
{
System.out.println(e);
}
return "false";
}
}
