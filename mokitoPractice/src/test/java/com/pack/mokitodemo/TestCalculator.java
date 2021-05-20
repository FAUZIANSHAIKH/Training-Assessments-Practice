package com.pack.mokitodemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestCalculator 
{
	Calculator c1=null;
	CalculatorService cs=Mockito.mock(CalculatorService.class);
	@Test
	public void testOperation() 
	{
		assertEquals(0,c1.performCalculation(cs));
		System.out.println("Testing operation.....");
	}
	
	@Before
	public void createObject()
	{
		System.out.println("Object created....");
		
		c1=new Calculator();
		
				

	}
	@After
	public void remove()
	{
		System.out.println("Object deferenced....");
		
		c1=null;
		
				

	}
}
