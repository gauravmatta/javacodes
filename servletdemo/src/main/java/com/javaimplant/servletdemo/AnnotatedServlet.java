package com.javaimplant.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/savedata")
public class AnnotatedServlet extends HttpServlet {

	private static final long serialVersionUID = 612863204779243604L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		try (PrintWriter writer = resp.getWriter()) {
			writer.write(name+" has email "+email);
		}
	}
	
	
}
