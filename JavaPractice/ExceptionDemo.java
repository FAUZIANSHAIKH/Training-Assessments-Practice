import java.io.*;
class Abc
{
public void A() throws userExc,NullPointerException,IOException{

int a=50;
for(int i=0;i<a;i++)
{
System.out.println(i);
int res=a/(a-i);
if(i==10) throw new userExc("when i is 10");
if(i==20) throw new IOException();
if(i==10) throw new NullPointerException();
}


}

public void atoz() throws userExc,NullPointerException,IOException
{
B();
}
public void B() throws userExc,NullPointerException,IOException
{
A();
}
}
public class ExceptionDemo
{
public static void main(String args[])
{
try
{
Abc ab=new Abc();
ab.atoz();
}
catch(IOException ioe)
{
System.out.println(ioe);
}
catch(NullPointerException np)
{
System.out.println(np);
}
catch(userExc ue)
{

ue.printStackTrace();
ue.display();
System.out.println("message"+ue.getMessage());
}
catch(Exception e)
{
e.printStackTrace();
}
finally
{
System.out.println("hi");
}
System.out.println("Program continues");
}
}
class userExc extends Exception
{
public userExc()
{

}
public userExc(String s)
{
super(s);
}
public void display()
{
System.out.println("In userExceoption");
}
}