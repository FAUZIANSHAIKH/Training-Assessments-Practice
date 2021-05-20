package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Jdbccon;


public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmpServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("t1");
		String pass=request.getParameter("t2");
		PrintWriter out=response.getWriter();
		Jdbccon jd=new Jdbccon();
		if(jd.check(name,pass)==true)
		{
			RequestDispatcher rd=request.getRequestDispatcher("log1.jsp");
			rd.forward(request, response);
		}
		else 
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("log2.jsp");
				rd.include(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
