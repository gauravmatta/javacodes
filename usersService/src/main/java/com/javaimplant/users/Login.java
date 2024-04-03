package com.javaimplant.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 8683008402889885994L;
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
		PrintWriter out= resp.getWriter();
		resp.setContentType("text/html");
		try(PreparedStatement ps = conn.prepareStatement("select * from users where email=? and password=?"))
		{
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				var rd = req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			}else {
				out.print("<h3>Email and Password didn't match</h3>");
				var rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
		} catch (SQLException e) {
			out.print("<h3>"+e.getMessage()+"</h3>");
			var rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
	}
}
