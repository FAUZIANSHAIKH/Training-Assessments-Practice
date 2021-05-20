package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateSearch() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in update search");
		int id=Integer.parseInt(request.getParameter("t1"));
		EmpDaoImp ed=new EmpDaoImp();
		System.out.println(id);
		Beans b=ed.getUser(id);
		System.out.println(b);
		PrintWriter out=response.getWriter();
		out.println(b);
		RequestDispatcher rd=request.getRequestDispatcher("Update1.html");
		rd.include(request,response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
