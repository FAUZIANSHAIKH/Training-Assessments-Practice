package com.pack.TestingDemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCalculator {
	Calculator c1;
	@Test
	public void testAdd() 
	{
		//fail("Not yet implemented");
		assertEquals("Addition is not proper",40,c1.add(20, 20));
		System.out.println("testAdd() checking");
	}
	@Test
	public void testSub() 
	{
		//fail("Not yet implemented");
		assertEquals("Subtraction is not proper",30,c1.sub(50, 20));
	}
	@Before
	public void  createObject()
	{
		c1=new Calculator();
		System.out.println("Object created......");
	}
	@After
	public void removeObject()
	{
		c1=null;
		System.out.println("Object dereferenced......");
	}
	@BeforeClass
	public static void abc()
	{
		System.out.println("FIRST");
	}
	@AfterClass
	public static void xyz()
	{
		System.out.println("LAST");
	}
	@Test
	public void isEqual()
	{
		assertTrue("a and b are not equal",c1.compare(20, 20));
	}
	@Test
	public void isNotEqual()
	{
		assertFalse("a and b are equal",c1.compare(20, 20));
	}
}
