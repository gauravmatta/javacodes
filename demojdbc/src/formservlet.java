

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formservlet
 */
@WebServlet("/formservlet")
public class formservlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public formservlet() {
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
		try
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String jdbcUrl="jdbc:mysql://localhost:3306/jdbc_test";
				String uname="root";
				String pwd="";
				Connection connection=null;
				connection=DriverManager.getConnection(jdbcUrl, uname, pwd);
				Statement statement=connection.createStatement();
				String x=request.getParameter("ename");
				String y=request.getParameter("dept");
				String sql="insert into emp (name,dept) values ('"+x+"','"+y+"')";
				statement.executeUpdate(sql);
				out.println("Record Added Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("/form.html");
				rd.include(request,response);
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
