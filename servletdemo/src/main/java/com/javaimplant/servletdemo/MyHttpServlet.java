package com.javaimplant.servletdemo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 6668592872752379842L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("I am in doGet() method");
		super.doGet(req, resp);
	}
}
