package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.BlogEntryDAO;
import mx.ipn.upiicsa.segsw.labicla.dao.JokesDAO;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/load_joke_to_be_modified.controller")
public class LoadJokeToBeModifiedServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doSomething(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doSomething(request, response);
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		JokesDAO dao = null;
		JokeValueObject jokeValueObject = null;
		UserValueObject user = (UserValueObject) request.getSession().getAttribute("user");
		List<JokeValueObject> jokeList = null;
		
		if( user  == null)
		{
			request.setAttribute("message", "Debe firmarse al sistema para modificar chistes.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		String strId = request.getParameter("id");
		
		if(Utility.containsAnEmptyValue(strId))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		try 
		{
			int id = Integer.parseInt(strId);
			
			dao = new JokesDAO();
			//jokeList= dao.findById(id);
			jokeValueObject = dao.findById(id);
			
			if(jokeValueObject != null && (jokeValueObject.getJokeCreatorEmail().equals(user.getEmail()) || user.getEmail().equals("admin@novalidserver.net")))
			{
				request.setAttribute("jokeToBeUpdated", jokeValueObject);
				//request.setAttribute("jokeList", jokeList);
			}
			else
			{
				request.setAttribute("message", "La entrada al blog no puede ser actualizada: No existe el id o usted no tiene permisos.");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("modify_joke.jsp");
			rd.forward(request, response);
			return;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return;
		}
		finally
		{
			if(dao != null) dao.closeConnection();
		}
	}
}

