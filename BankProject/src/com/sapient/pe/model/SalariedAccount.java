package com.sapient.pe.model;

public class SalariedAccount extends SupAccount {
	
	public SalariedAccount(Employee emp) {
		super(emp);
		// TODO Auto-generated constructor stub
	}
	private double accountBalance;


	public void deposit(double amount)
	{
		if(amount<=50000)
	this.accountBalance +=amount;
		else
			System.out.println("cant deposit");
	}
	public void withdraw(double amount)
	{	
	if((this.accountBalance-amount)>=0)
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
