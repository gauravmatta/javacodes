package com.javaimplant.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 722671319763608252L;
	private Connection conn;

	@Override
	public void init() throws ServletException {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String Database_URL = "jdbc:mysql://localhost:3306/Users";
		final String Database_USER = "root";
		final String Database_PASS = "root@04G";
		try {
			Class.forName(JDBC_DRIVER);
			this.conn = DriverManager.getConnection(Database_URL, Database_USER, Database_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var rd = req.getRequestDispatcher("/register.jsp");
		PrintWriter out= resp.getWriter();		
		try(PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?,?)"))
		{
			String myname = req.getParameter("name");
			String myemail = req.getParameter("email");
			String mypass = req.getParameter("pass");
			String mygender = req.getParameter("gender");
			String mycity = req.getParameter("city");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, mygender);
			ps.setString(5, mycity);
			int count = ps.executeUpdate();
			if(count > 0) {
				resp.setContentType("text/html");
				out.println("<h3>User Registered Successfully</h3>");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.println("<h3>Failed to Register User</h3>");
				rd.include(req, resp);
			}
		} catch(SQLException | ServletException e) 
		{
			resp.setContentType("text/html");
			out.println("<h3>Exception Ocurred"+e.getMessage()+"</h3>");
			rd.include(req, resp);
		}
	}

}
