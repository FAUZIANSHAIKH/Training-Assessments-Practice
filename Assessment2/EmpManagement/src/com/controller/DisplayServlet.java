package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.crypto.provider.RSACipher;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DisplayServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		Beans b=new Beans();
		
		
		EmpDaoImp ed=(EmpDaoImp)ctx.getBean("empidimp");
		PrintWriter pw=response.getWriter();
		ArrayList<Beans> list=ed.display();
		for(int i=0;i<list.size();i++)
		{
			pw.println(list.get(i));
		}
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
