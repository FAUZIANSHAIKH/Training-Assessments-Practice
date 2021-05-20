package com.example.demo;


public class UserDAO
{
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDAO [name=" + name + ", password=" + password + "]";
	}
	
}
//	private int rollno;
//	private String name;
//	private String school;
//	public int getRollno() {
//		return rollno;
//	}
//	public void setRollno(int rollno) {
//		this.rollno = rollno;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getSchool() {
//		return school;
//	}
//	public void setSchool(String school) {
//		this.school = school;
//	}
//	@Override
//	public String toString() {
//		return "Student [rollno:" + rollno + ", name:" + name + ", school:" + school + "]";
//	}
//
//	
//}
