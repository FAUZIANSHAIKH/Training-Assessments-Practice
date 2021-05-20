package com.sapient.pe.model;
import java.util.Comparator;
public class Comparators
{

	public  static class Idsorterasc implements Comparator<SupAccount>
	{
	public int compare(SupAccount o1,SupAccount o2)
	{
		return Integer.valueOf((int)o1.getAccountId()).compareTo((int)o2.getAccountId());
	}
	}
	public  static class  Idsorterdesc implements Comparator<SupAccount>
	{
	public int compare(SupAccount o1,SupAccount o2)
	{
		return Integer.valueOf((int)o2.getAccountId()).compareTo((int)o1.getAccountId());
	}
	}
	public  static class Namesortasc implements Comparator<Employee>
	{
		public int compare(Employee o1,Employee o2)
		{
			return String.valueOf(o2.getName()).compareTo(o1.getName());
		}
	}
	public  static class Namesortdesc implements Comparator<Employee>
	{
		public int compare(Employee o1,Employee o2)
		{
			return String.valueOf(o2.getName()).compareTo(o1.getName());
		}
	}}
	
	


