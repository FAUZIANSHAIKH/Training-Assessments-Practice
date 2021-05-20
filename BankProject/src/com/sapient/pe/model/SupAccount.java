package com.sapient.pe.model;

import java.util.Comparator;

public abstract class SupAccount 
{
	
	
	private final long   accountId;
	private double accountBalance;

	private static double minaccountBalance ;
	private static long accountIdCounter = 100;
	
	 private final Employee emp;
	 public SupAccount(Employee emp)
		{
		this.accountId = ++accountIdCounter;
		this.emp=emp;

		}
	public long getAccountId() {
		return accountId;
	}
	
	
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountId ^ (accountId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupAccount other = (SupAccount) obj;
		if (accountId != other.accountId)
			return false;
		return true;
	}
public abstract void deposit(double dep) ;
  public abstract void withdraw(double dep);

	public abstract double checkBalance();
	
	public String getName() {
		
		return emp.getName();
	}
}
