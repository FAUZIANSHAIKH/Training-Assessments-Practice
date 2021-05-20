package com.sapient.pe.model;

public class SavingAccount extends SupAccount{

	public SavingAccount(Employee emp) {
		super(emp);
		
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
		if(amount<=25000) {
	if((this.accountBalance-amount)>=0)
	{
	this.accountBalance-=amount;

	
	}
	else
	System.out.println("You do not have sufficient funds");

	}
		else
			System.out.println("cant withdraw");
	}
	public double checkBalance()
	{
	return this.accountBalance;
	}

	}

	


