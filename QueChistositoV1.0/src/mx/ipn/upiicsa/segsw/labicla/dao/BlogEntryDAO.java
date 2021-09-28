
package mx.ipn.upiicsa.segsw.labicla.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.ipn.upiicsa.segsw.labicla.exception.DAOInitializationException;
import mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class BlogEntryDAO  extends DataAccessObject
{

	public BlogEntryDAO() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	/**
	 * 
	 * @param BlogEntry
	 */
	public void create(BlogEntryValueObject blogEntry)  throws SQLException, DAOInitializationException
	{
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO blog_entries (user_email, entry_value, registration_date) VALUES (?, ?, now())";
		
		System.out.println("BlogEntryDAO.create() - SQL - " + sql);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, blogEntry.getUserEmail());
			stmt.setString(2, blogEntry.getValue());
			
			stmt.executeUpdate();
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	/**
	 * 
	 * @param id
	 * @throws SQLException
	 * @throws DAOInitializationException
	 */
	public void delete(int id)  throws SQLException, DAOInitializationException
	{
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM blog_entries where id = ?";
		
		System.out.println("BlogEntryDAO.delete() - SQL - " + sql);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	/**
	 * 
	 * @param blogEntry
	 * @throws SQLException
	 * @throws DAOInitializationException
	 */
	public void update(BlogEntryValueObject blogEntry)  throws SQLException, DAOInitializationException
	{
		PreparedStatement stmt = null;
		
		String sql = "UPDATE blog_entries SET entry_value = ? WHERE id = ?";
		
		System.out.println("BlogEntryDAO.update() - SQL - " + sql);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, blogEntry.getValue());
			stmt.setInt(2, blogEntry.getId());
			
			stmt.executeUpdate();
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	/**
	 * 
	 * @param criteria
	 * @return
	 * @throws SQLException
	 * @throws DAOInitializationException
	 */
	public List<BlogEntryValueObject> findByCriteria(String criteria) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		BlogEntryValueObject blogEntry = null;
		
		List<BlogEntryValueObject> blogEntryList = new ArrayList<BlogEntryValueObject>();
		
		String sql = "SELECT * FROM blog_entries WHERE entry_value LIKE ?";
		
		System.out.println("BlogEntryDAO.findByCriteria() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, "%" + criteria + "%");
			
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				blogEntry = new BlogEntryValueObject();
				
				blogEntry.setId(rs.getInt("id"));
				blogEntry.setUserEmail(rs.getString("user_email"));
				blogEntry.setValue(rs.getString("entry_value"));
				blogEntry.setRegistrationDate(new Date(rs.getTimestamp("registration_date").getTime()));
				
				blogEntryList.add(blogEntry);
			}
			return blogEntryList;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}
	
	public BlogEntryValueObject findById(int id) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		BlogEntryValueObject blogEntry = null;
		
		String sql = "SELECT * FROM blog_entries WHERE id = ?";
		
		System.out.println("BlogEntryDAO.findById() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next())
			{
				blogEntry = new BlogEntryValueObject();
				
				blogEntry.setId(rs.getInt("id"));
				blogEntry.setUserEmail(rs.getString("user_email"));
				blogEntry.setValue(rs.getString("entry_value"));
				blogEntry.setRegistrationDate(new Date(rs.getTimestamp("registration_date").getTime()));
			}
			
			return blogEntry;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		
	}
	
}

