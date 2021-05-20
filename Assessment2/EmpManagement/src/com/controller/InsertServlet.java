package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		Beans b=new Beans();
		b.setId(Integer.parseInt(request.getParameter("t1")));
		b.setName(request.getParameter("t2"));
		b.setSalary(Integer.parseInt(request.getParameter("t3")));
		b.setAddress(request.getParameter("t4"));
		b.setRole(request.getParameter("t5"));
		EmpDaoImp ed=(EmpDaoImp)ctx.getBean("empidimp");
		
		ed.insert(b);
		RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);
		
			}

}
