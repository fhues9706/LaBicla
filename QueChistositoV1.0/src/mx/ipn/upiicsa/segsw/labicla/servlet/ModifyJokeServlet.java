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
@WebServlet("/modify_joke.controller")
public class ModifyJokeServlet extends HttpServlet implements Servlet {
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
		JokeValueObject jokeValueObject;
		JokesDAO dao = null;
		JokeValueObject JokeValueObject=null;
		UserValueObject user = (UserValueObject) request.getSession().getAttribute("user");
		ErrorValueObject error = null;
		
		if( user  == null)
		{
			request.setAttribute("message", "Debe firmarse al sistema para modificar chistes.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		String strId =( request.getParameter("id"));		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String key_words = request.getParameter("key_words");
		String content = request.getParameter("content");
		String image = request.getParameter("image");
		//System.out.println(strId);
		
		if(Utility.containsAnEmptyValue(strId, name, category, key_words, content, image))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		//validacion con er
		
		if(name.matches("[A-Za-z0-9.#$%&¡?¿!,_ ]+")==true && category.matches("[A-Za-z]+")==true && key_words.matches("[A-Za-z,.¡?¿!,_ ]+")==true && content.matches("[A-Za-z0-9.#$%&?!,¡¿_ ]+")==true && image.matches("[A-Za-z0-9.+=#$%&/,!?:_¡¿]+")==true && strId.matches("[0-9]+")) {

		try 
		{
			
			int id = Integer.parseInt(strId);
			dao = new JokesDAO();
			
			jokeValueObject = dao.findById(id);
			
			if(jokeValueObject != null && (jokeValueObject.getJokeCreatorEmail().equals(user.getEmail()) || user.getEmail().equals("admin@novalidserver.net")))
			{
				
				jokeValueObject.setId(id);
				jokeValueObject.setName(name);
				
				jokeValueObject.setCategory(category);
				jokeValueObject.setKeyWords(key_words);
				jokeValueObject.setContent(content);
				jokeValueObject.setImage(image);
				//System.out.println(id + name + category + key_words +content+image);
				dao.update(jokeValueObject);
				request.setAttribute("message", "Chiste modificado");
			}
			else
			{
				request.setAttribute("message", "El chiste no puede ser actualizad: No existe el id o usted no tiene permisos.");
			}
			
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
			
			error.setMessage("Ah perro!!!");
			error.setDescription("<h1>Con que intentando hackearme desde el modulo modificacion  >:v</h1>");
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
