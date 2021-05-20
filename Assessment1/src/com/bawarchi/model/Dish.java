package com.bawarchi.model;

public class Dish  implements Comparable<Dish>
{
	private int id;
	private String name;
	private double price;
	private double calories;
	
	public  Dish(int id,String name,double price,double calories)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.calories=calories;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	@Override
	public int compareTo(Dish o) {
		
		return this.id-o.id;
	}
	
	
	@Override
	public String toString() {
		return "\nDish Id: "+id+", name: "+name+", Price: "+price+",  Calories: "+calories+"\n";
	}
	
	
}
