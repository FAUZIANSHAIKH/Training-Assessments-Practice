package com.controller;


public class Beans 
{
	@Override
	public String toString() {
		return "Beans [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", address=" + address + ", role=" + role + "]";
	}
	private int id;
	private String name;
	private int salary;
	private String address;
	private String role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
