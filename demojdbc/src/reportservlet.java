

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reportservlet
 */
@WebServlet("/reportservlet")
public class reportservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcUrl="jdbc:mysql://localhost:3306/emp";
				String uname="root";
				String pwd="";
				Connection connection=null;
				connection=DriverManager.getConnection(jdbcUrl, uname, pwd);
				Statement statement=connection.createStatement();
				String z=request.getParameter("dept");
				String sql="Select * from emp where dept='"+z+"'";
				out.println("<h1>Employee Details</h1>");
				ResultSet rs=statement.executeQuery(sql);
				out.println("<table border='2'>");
				out.println("<tr>");
				out.println("<th>ENAME</th>");
				out.println("<th>DEPT</th>");
				out.println("</tr>");
				while(rs.next())
				{
					String ename=rs.getString("name");
					String dept=rs.getString("dept");
					out.println("<tr>");
					out.println("<td>"+ename+"</td>");
					out.println("<td>"+dept+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
			}
			catch (ClassNotFoundException e) 
			{
				out.println("Class Not Found");
				e.printStackTrace();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Cannot connect the database!",e);
		}
	}

}
