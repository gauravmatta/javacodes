package com.javaimplant.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HomeServlet extends HttpServlet {

	private Logger logger=Logger.getLogger(this.getClass());
	private RequestDispatcher homeJsp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/feed.rss");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Hello, World!</h1>");
		BasicConfigurator.configure();
		logger.debug("Returning website");
		logger.debug("Returning message: bye");
//		req.setAttribute("message", "bye");
		homeJsp.forward(req, resp);
	}
	

}
