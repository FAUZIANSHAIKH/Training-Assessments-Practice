package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		Beans b=new Beans();
		b.setId(Integer.parseInt(request.getParameter("t1")));
		
		EmpDaoImp ed=(EmpDaoImp)ctx.getBean("empidimp");
		
		ed.delete(b);
		RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
		rd.forward(request, response);
		
	}

}
