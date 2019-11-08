package wiki.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DataAccessObject {
	
	private static DataSource dataSource;
	
	public static void setDataSource(DataSource dataSource)
	{
		DataAccessObject.dataSource = dataSource;
	}
	
	protected static Connection getConnection()
	{
		try 
		{
			return dataSource.getConnection();
		} 
		catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	protected static void close(Statement statement, Connection connection)
	{
		close(null, statement, connection);
	}
	
	protected static void close(ResultSet rs, Statement statement,Connection connection)
	{
			try 
			{
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} 
			catch (SQLException e) 
			{
				throw new RuntimeException(e);
			}
	}
}