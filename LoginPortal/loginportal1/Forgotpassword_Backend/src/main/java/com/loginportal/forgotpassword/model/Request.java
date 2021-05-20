package com.loginportal.forgotpassword.model;




public class Request {
	private int otp;
private String name;
public int getOtp() {
	return otp;
}
private String ans1;
private String pwd;
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
private String ans2;
public String getAns1() {
	return ans1;
}
public void setAns1(String ans1) {
	this.ans1 = ans1;
}
public String getAns2() {
	return ans2;
}
public void setAns2(String ans2) {
	this.ans2 = ans2;
}
public void setOtp(int otp) {
	this.otp = otp;
}
private int choice;
private String email;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getChoice() {
	return choice;
}
public void setChoice(int choice) {
	this.choice = choice;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
