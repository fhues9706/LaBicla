package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.UserDAO;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

@WebServlet("/authenticate_user.controller")
public class AuthenticateUserServlet extends HttpServlet implements Servlet 
{
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
		String referer = request.getHeader("referer");
		
		
		System.out.println("AuthenticateUserServlet {referer: " + referer  +"}");
		
		//seguridad para el request

		if(referer == null || referer.indexOf("http://127.0.0.1:8080/que-chistosito/") == -1)
		{
			request.setAttribute("message", "Operacion invalida.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		ErrorValueObject error = null;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(Utility.containsAnEmptyValue(email, password))
		{
			
			error = new ErrorValueObject();
			
			error.setMessage("Parametro faltante");
			error.setDescription("Falt&oacute; capturar algun campo obligatorio.");
			
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			return;
		}
		
		//implementacion de la validacion con expresion regular
		if(email.matches("^[a-z0-9._%+]+@[a-z0-9.]+\\.[a-z]{2,4}$")==false||password.matches("[A-Za-z0-9.#$@$!%*?&]{8,}")==false) {
					
			error = new ErrorValueObject();
					
			error.setMessage("¡Insistente!");
			error.setDescription("<h1>Los campos son incorrectos</h1>");
			request.setAttribute("error", error);
					
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			return;
							
		}
		
		UserDAO dao = null;
		UserValueObject user = null;
		
		try 
		{
			dao = new UserDAO();
			user = dao.authenticate(email, password);
			
			if(user != null) // Credenciales validas
			{
				Date currentDate = new Date();
				request.getSession().setAttribute("user", user);

				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				return;				
			}
			else // Las credenciales NO son validas
			{
				error = new ErrorValueObject();
				
				error.setMessage("Credenciales no validas");
				error.setDescription("Las credenciales proporcionadas no son correctas.");
				
				request.setAttribute("error", error);
				
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
					
			error = new ErrorValueObject();
			
			error.setMessage("Ocurrio un error al validar credenciales");
			error.setDescription(ex.getMessage());
			error.setException(ex);
			
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		finally
		{
			if(dao != null) dao.closeConnection();

		}
	}
}
