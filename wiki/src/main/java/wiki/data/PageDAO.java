package wiki.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PageDAO extends DataAccessObject {
	private static PageDAO instance = new PageDAO();
	
	public static PageDAO getInstance() 
	{
		return instance;
	}
	
	private Page read(ResultSet rs) throws SQLException 
	{
		String name = rs.getString("name");
		String content = rs.getString("content");
		boolean published = rs.getBoolean("published");
		String publishedId = rs.getString("published_id");
		Page page = new Page();
		page.setName(name);
		page.setContent(content);
		page.setPublished(published);
		page.setPublishedId(publishedId);
		return page;
	}
	
	public Page find(String name) 
	{
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try 
		{
			connection = getConnection();
			String sql = "select * from page where name=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			rs = statement.executeQuery();
			if (!rs.next()) 
			{
				return null;
			}
			return read(rs);
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
			
		} 
		finally 
		{
			close(rs, statement, connection);
		}
	}
	
	public void update(Page page) 
	{
		PreparedStatement statement = null;
		Connection connection = null;
		try 
		{
			connection = getConnection();
			String sql = "update page set content=?, published=?, published_id=? where name=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, page.getContent());
			statement.setBoolean(2, page.isPublished());
			statement.setString(3, page.getPublishedId());
			statement.setString(4, page.getName());
			statement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		} 
		finally 
		{
			close(statement, connection);
		}
	}
		
	public void create(Page page) 
	{
			PreparedStatement statement = null;
			Connection connection = null;
			try 
			{
				connection = getConnection();
				String sql = "insert into page (name, content) values (?, ?)";
				statement = connection.prepareStatement(sql);
				statement.setString(1, page.getName());
				statement.setString(2, page.getContent());
				statement.executeUpdate();
			} 
			catch (SQLException e) 
			{
				throw new RuntimeException(e);
			} 
			finally 
			{
				close(statement, connection);
			}
	}
			
	public void delete(Page page) 
	{
			PreparedStatement statement = null;
			Connection connection = null;
			try 
			{
				connection = getConnection();
				String sql = "delete from page where name=?";
				statement = connection.prepareStatement(sql);
				String name = page.getName();
				statement.setString(1, name);
				statement.executeUpdate();
			} 
			catch (SQLException e) 
			{
				throw new RuntimeException(e);
			} 
			finally 
			{
				close(statement, connection);
			}
	}
}