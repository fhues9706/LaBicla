package mx.ipn.upiicsa.segsw.labicla.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.segsw.labicla.exception.DAOInitializationException;
import mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class JokesDAO  extends DataAccessObject
{

	public JokesDAO() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	
	public JokeValueObject findById(Integer id) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		JokeValueObject joke = null;
		List<JokeValueObject> jokeList = new ArrayList<JokeValueObject>();
		
		String sql = "SELECT * FROM jokes WHERE id = ?";
		
		System.out.println("JokesDAO.findByCriteria() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next())
			{
				joke = new JokeValueObject();
				
				joke.setId(rs.getInt("id"));
				joke.setJokeCreatorEmail(rs.getString("joke_creator_email"));
				joke.setName(rs.getString("name"));
				joke.setCategory(rs.getString("category"));
				joke.setKeyWords(rs.getString("key_words"));
				joke.setContent(rs.getString("content"));
				joke.setImage(rs.getString("image"));
				jokeList.add(joke);
			}
			
			return joke;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		
	}
	
	public List<JokeValueObject> findByAuthor(String author) throws SQLException, DAOInitializationException{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		JokeValueObject joke = null;
		
		List<JokeValueObject> jokeList = new ArrayList<JokeValueObject>();
		String sql = "SELECT * FROM jokes WHERE joke_creator_email LIKE ? ";
		System.out.println("JokesDAO.findByAuthor() - SQL - " + sql);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, "%" + author + "%");
			
			rs = stmt.executeQuery();
			
			
			while(rs.next())
			{
				joke = new JokeValueObject();
				
				joke.setId(rs.getInt("id"));
				joke.setJokeCreatorEmail(rs.getString("joke_creator_email"));
				joke.setName(rs.getString("name"));
				joke.setCategory(rs.getString("category"));
				joke.setKeyWords(rs.getString("key_words"));
				joke.setContent(rs.getString("content"));
				joke.setImage(rs.getString("image"));
				jokeList.add(joke);
			}
			
			return jokeList;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}
	
	public List<JokeValueObject> findByName(String name) throws SQLException, DAOInitializationException{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		JokeValueObject joke = null;
		
		List<JokeValueObject> jokeList = new ArrayList<JokeValueObject>();
		String sql = "SELECT * FROM jokes WHERE name LIKE ? ";
		System.out.println("JokesDAO.findByAuthor() - SQL - " + sql);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1,name);
			
			rs = stmt.executeQuery();
			
			
			while(rs.next())
			{
				joke = new JokeValueObject();
				
				joke.setId(rs.getInt("id"));
				joke.setJokeCreatorEmail(rs.getString("joke_creator_email"));
				joke.setName(rs.getString("name"));
				joke.setCategory(rs.getString("category"));
				joke.setKeyWords(rs.getString("key_words"));
				joke.setContent(rs.getString("content"));
				joke.setImage(rs.getString("image"));
				jokeList.add(joke);
			}
			
			return jokeList;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}
	
	
	public List<JokeValueObject> findByCriteria(String criteria) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		JokeValueObject joke = null;
		
		List<JokeValueObject> jokeList = new ArrayList<JokeValueObject>();
		
		String sql = "SELECT * FROM jokes WHERE name LIKE ?";
		
		System.out.println("JokesDAO.findByCriteria() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, "%" + criteria + "%");
			
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				joke = new JokeValueObject();
				
				joke.setId(rs.getInt("id"));
				joke.setJokeCreatorEmail(rs.getString("joke_creator_email"));
				joke.setName(rs.getString("name"));
				joke.setCategory(rs.getString("category"));
				joke.setKeyWords(rs.getString("key_words"));
				joke.setContent(rs.getString("content"));
				joke.setImage(rs.getString("image"));
				jokeList.add(joke);
			}
			
			return jokeList;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}


	public List<JokeValueObject> findByCategory(String criteria) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		JokeValueObject joke = null;
		
		List<JokeValueObject> jokeList = new ArrayList<JokeValueObject>();
		
		String sql = "SELECT * FROM jokes WHERE category LIKE ?";
		
		System.out.println("JokesDAO.findByCategory() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, "%" + criteria + "%");
			
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				joke = new JokeValueObject();
				
				joke.setId(rs.getInt("id"));
				joke.setJokeCreatorEmail(rs.getString("joke_creator_email"));
				joke.setName(rs.getString("name"));
				joke.setCategory(rs.getString("category"));
				joke.setKeyWords(rs.getString("key_words"));
				joke.setContent(rs.getString("content"));
				joke.setImage(rs.getString("image"));
				jokeList.add(joke);
			}
			
			return jokeList;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}
	
	
	public void create(JokeValueObject joke) throws SQLException, DAOInitializationException{
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO jokes (joke_creator_email, name, category, key_words, content,image) VALUES (?, ?, ?, ?, ?, ?)";
		
		System.out.println("JokesDAO.create() - SQL - " + sql);
		System.out.println("JokesDAO.create() - joke - " + joke);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, joke.getJokeCreatorEmail());
			stmt.setString(2, joke.getName());
			stmt.setString(3, joke.getCategory());
			stmt.setString(4, joke.getKeyWords());
			stmt.setString(5, joke.getContent());
			stmt.setString(6, joke.getImage());
		
			
			stmt.executeUpdate();
			
			
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	
	public void delete(int id)  throws SQLException, DAOInitializationException
	{
		PreparedStatement stmt = null;
		
		String sql = "DELETE FROM jokes where id = ?";
		
		System.out.println("JokesDAO.delete() - SQL - " + sql);
		
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
	
	public void update(JokeValueObject joke)  throws SQLException, DAOInitializationException
	{
		PreparedStatement stmt = null;
		
		String sql = "UPDATE jokes SET name = ?, category = ?, key_words= ?, content= ?, image= ? WHERE id = ?";
		
		System.out.println("JokesDAO.update() - SQL - " + sql);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, joke.getName());
			stmt.setString(2, joke.getCategory());
			stmt.setString(3, joke.getKeyWords());
			stmt.setString(4, joke.getContent());
			stmt.setString(5, joke.getImage());
			stmt.setInt(6, joke.getId());
			System.out.println(joke.getName() + joke.getCategory() + joke.getContent() + joke.getId() + joke.getImage());
			stmt.executeUpdate();
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	
}
