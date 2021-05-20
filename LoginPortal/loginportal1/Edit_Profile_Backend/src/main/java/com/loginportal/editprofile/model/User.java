package com.loginportal.editprofile.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table(name = "register") // This tells Hibernate to make a table out of this class
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;

	private String userRole="user";
	
	

	//@Column(name = "first_name")
	@NotBlank
	private String firstName;
	//@Column(name = "last_name")
	@NotBlank
	private String lastName;
	//@Column(name="emailid" , unique = true,length=100)
	@NotBlank
	@Email
	private String emailID;
	//@Column(name = "phone_no")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNo;
	
	private String gender;
	private String maritalStatus;
	private String profession;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userRole=" + userRole + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailID=" + emailID + ", phoneNo=" + phoneNo + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", profession=" + profession + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
