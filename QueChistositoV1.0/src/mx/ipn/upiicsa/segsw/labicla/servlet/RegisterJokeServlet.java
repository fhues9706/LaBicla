package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;

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
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/register_joke.controller")
public class RegisterJokeServlet extends HttpServlet implements Servlet {
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
		ErrorValueObject error = null;
		
		if( user  == null)
		{
			request.setAttribute("message", "Debe firmarse al sistema para registrar chistes.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		String jokeEntryValue = request.getParameter("content");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String key_words = request.getParameter("key_words");
		String image = request.getParameter("image");
		
		if(Utility.containsAnEmptyValue(jokeEntryValue,name,category,key_words,image))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		//validacion con er
		
		if(name.matches("[A-Za-z0-9.#$%&¿?¡! ]+")==true && category.matches("[A-Za-z]+")==true && key_words.matches("[A-Za-z,. ]+")==true && jokeEntryValue.matches("[ A-Za-z0-9.#$%&?!,¿¡_ ]+")==true && image.matches("[A-Za-z0-9.+=#$%&/,!?:¡¿_]+")==true ) {
		try 
		{
			dao = new JokesDAO();
			//jokeValueObject=dao.findByName(name);
			
			
			jokeValueObject = new JokeValueObject();
			jokeValueObject.setJokeCreatorEmail(user.getEmail());
			jokeValueObject.setName(name);
			jokeValueObject.setCategory(category);
			jokeValueObject.setKeyWords(key_words);
			jokeValueObject.setContent(jokeEntryValue);
			jokeValueObject.setImage(image);
			
			dao.create(jokeValueObject);
			//con esto agregas texto cuando ejecutas una accion
			request.setAttribute("message", "Chiste registrado con exito! ");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
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
		}}else {
			error = new ErrorValueObject();
			
			error.setMessage("Caracteres invalidos");
			error.setDescription("<h1>No ingreses caracteres no permitidos</h1>");
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
	}
}



