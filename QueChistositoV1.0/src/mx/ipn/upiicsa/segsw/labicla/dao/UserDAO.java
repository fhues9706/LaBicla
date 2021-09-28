package mx.ipn.upiicsa.segsw.labicla.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import mx.ipn.upiicsa.segsw.labicla.exception.DAOInitializationException;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class UserDAO extends DataAccessObject{

	public UserDAO() throws ClassNotFoundException, SQLException {
		
		super();
	}
	/**
	 * 
	 * @param user
	 * @throws SQLException
	 * @throws DAOInitializationException
	 */
	public UserValueObject create(UserValueObject user) throws SQLException, DAOInitializationException
	{
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
		
		System.out.println("UserDAO.create() - SQL - " + sql);
		System.out.println("UserDAO.create() - user - " + user);
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstname());
			stmt.setString(4, user.getLastname());
			
			stmt.executeUpdate();
			
			return user;
		}
		finally
		{
			closeStatement(stmt);
		}
	}
	/**
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 * @throws DAOInitializationException
	 */
	public UserValueObject findById(String email) throws SQLException, DAOInitializationException
	{
		UserValueObject user = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM users WHERE email = ?";
		System.out.println("UserDAO.authenticate() - SQL - " + sql);
		
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, email);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) // Encontro un registro -- Credenciales validas
			{
				user = new UserValueObject();
				
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				
				
				return user;
			}
			else
			{
				return null;
			}
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws DAOInitializationException
	 */
	public UserValueObject authenticate(String email, String password) throws SQLException, DAOInitializationException
	{
		UserValueObject user = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String sql = "SELECT * FROM users WHERE email = ?  AND password = ?";
		System.out.println("UserDAO.authenticate() - SQL - " + sql);
		
		
		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, email);
			stmt.setString(2, password);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) // Encontro un registro -- Credenciales validas
			{
				user = new UserValueObject();
				
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
			
				
				return user;
			}
			else
			{
				return null;
			}
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}
}
