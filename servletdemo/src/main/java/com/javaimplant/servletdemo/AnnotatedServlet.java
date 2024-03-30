package com.javaimplant.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/savedata")
public class AnnotatedServlet extends HttpServlet {

	private static final long serialVersionUID = 612863204779243604L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
//		System.out.println("In Service");
		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		req.setAttribute("name_key", name);
		HttpSession session = req.getSession();
		session.setAttribute("name_key",name);
		session.setAttribute("email_key",email);
		try (PrintWriter writer = resp.getWriter()) {
			resp.setContentType("text/html");
			writer.print(name+" has email "+email);
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.include(req, resp);
		}
	}
	
	
}
