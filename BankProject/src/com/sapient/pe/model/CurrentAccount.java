package com.sapient.pe.model;

public class CurrentAccount extends SupAccount{
	private static double minaccountBalance =25000;
	public CurrentAccount(Employee emp) {
		super(emp);
		// TODO Auto-generated constructor stub
	}
	private double accountBalance;


	public void deposit(double amount)
	{
		
	this.accountBalance +=amount;
		
	}
	public void withdraw(double amount)
	{	
	if((this.accountBalance-amount)>=minaccountBalance)
	{
	this.accountBalance-=amount;

	
	}
	else
	System.out.println("You do not have sufficient funds");

	}
	public double checkBalance()
	{
	return this.accountBalance;
	}

}
