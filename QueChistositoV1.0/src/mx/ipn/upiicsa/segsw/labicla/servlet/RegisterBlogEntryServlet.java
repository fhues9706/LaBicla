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
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/register_blog_entry.controller")
public class RegisterBlogEntryServlet extends HttpServlet implements Servlet {
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
		ErrorValueObject error = null;
		BlogEntryDAO dao = null;
		BlogEntryValueObject blogEntryValueObject = null;
		UserValueObject user = (UserValueObject) request.getSession().getAttribute("user");
		
		if( user  == null)
		{
			request.setAttribute("message", "Debe firmarse al sistema para registrar entradas en el blog.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		String blogEntryValue = request.getParameter("blog-entry-value");
		
		if(Utility.containsAnEmptyValue(blogEntryValue))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		//implementacion de validacionER
		if(blogEntryValue.matches("[ A-Za-z0-9.#$@$!%*?¡¿,_ ]+")==true) {
		try 
		{
			dao = new BlogEntryDAO();
			
			blogEntryValueObject = new BlogEntryValueObject();
			
			blogEntryValueObject.setValue(blogEntryValue);
			blogEntryValueObject.setUserEmail(user.getEmail());
			
			dao.create(blogEntryValueObject);
			request.setAttribute("message", "La entrada del blog fue registrada correctamente.");
			RequestDispatcher rd = request.getRequestDispatcher("get_blog_info.controller");
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
			
			error.setMessage("Error caracteres invalidos");
			error.setDescription("<h1>No se aceptan los siguientes caracteres: < > - ' <br> Introduce solo caracteres validos</h1>");
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
	}
}



