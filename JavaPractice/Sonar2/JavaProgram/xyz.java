import java.util.*;
class Person
{
	String name;
	int age;
}
class xyz
{
	public static void main(String args[])
	{
		LinkedList l1=new LinkedList();
		l1.add(11);
		l1.add(22);
		l1.add(33);
		l1.add(44);
		System.out.println(l1);
		Person p1=new Person();
		p1.name="Ramesh";
		p1.age=25;
		System.out.println("Name : "+p1.name);
		System.out.println("Age : "+p1.age);
	}
}