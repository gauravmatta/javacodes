package com.javaimplant.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 6668592872752379842L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("I am in doGet() method of Http Servlet");
		System.out.println("I am in doGet() method");
	}
}
