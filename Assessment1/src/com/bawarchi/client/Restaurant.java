package com.bawarchi.client;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.bawarchi.comparators.Comp;
import com.bawarchi.model.Dish;


public class Restaurant 
{	
	
	
	public static void main(String args[])
	{	
		List<Dish> dishList=new ArrayList<Dish>();
		Dish d1=new Dish(5,"Neer-Dosa",50.00,100);
		Dish d2=new Dish(2,"Idli-Vada",40.00,200);
		Dish d3=new Dish(4,"Roti-Curry",100.00,250);
		Dish d4=new Dish(1,"Dosa",50.00,300);
		Dish d5=new Dish(3,"Pulav",80.00,330);
		dishList.add(d1);
		dishList.add(d2);
		dishList.add(d3);
		dishList.add(d4);
		dishList.add(d5);
		System.out.println("==================Welcome=====================");
		System.out.println("Please choose from the below options");
		System.out.println("1 => To sort the dishes in the increasing order of calories");
		System.out.println("2 => To sort the dishes in the decreasing order of calories");
		System.out.println("3 => To sort the dishes in the increasing order of price");
		System.out.println("4 => To sort the dishes in the decreasing order of price");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:Collections.sort(dishList,Comp.getComparator(Comp.CompType.CALORIES_ASC));
		
		break;
		case 2:Collections.sort(dishList,Comp.getComparator(Comp.CompType.CALORIES_DESC));
		
		break;
		case 3:Collections.sort(dishList,Comp.getComparator(Comp.CompType.PRICE_ASC));
		
		break;
		case 4:Collections.sort(dishList,Comp.getComparator(Comp.CompType.PRICE_DESC));
		
		break;
		}
		
		System.out.println(" =================Please select the Dish Id and hit enter===============================");
		System.out.println(dishList);
		System.out.println("============================================================");
		int dishId=sc.nextInt();
		Dish dishorder=null;
		Iterator<Dish> it=dishList.iterator();
		while(it.hasNext()) {
			Dish dish=it.next();
			if(dish.getId()==dishId) {
				dishorder=dish;
				break;
			}
		}
		
		System.out.println("  ==========You have selected "+dishorder.getName()+" =====================");
		System.out.println("Please enter ur name:");
		String uname=sc.next();
		System.out.println(" Please pay the bill of Rs"+dishorder.getPrice()+" (wait for user input)");
		int paid=sc.nextInt();
		
		int change=(int)(paid-dishorder.getPrice());
		if(change>0)
			System.out.println("========Thanks for your order. Please collect the change = Rs "+change+" ================");
		else if(change<0)
			System.out.println("========Amount paid is less than Bill Amount ================");
		else System.out.println(" ========Thanks for your order. ================");
	}

	
	}

