package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.UserDAO;
import mx.ipn.upiicsa.segsw.labicla.util.SecurityUtility;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/register_user.controller")
public class RegisterUserServlet extends HttpServlet implements Servlet {
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
		UserDAO dao = null;
		
		UserValueObject user = null;
		
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String passwordConfirmation = request.getParameter("password-confirmation");
		
		if(Utility.containsAnEmptyValue(email, firstname, lastname, password, passwordConfirmation))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		//validacion con er
		if(email.matches("^[a-z0-9._%+]+@[a-z0-9.]+\\.[a-z]{2,4}$")==true && firstname.matches("[ A-Za-z]+")==true && lastname.matches("[ A-Za-z]+")==true && password.matches("[A-Za-z0-9.#$%&?!_]+")==true  && passwordConfirmation.matches("[A-Za-z0-9.#$%&?!_]+")==true ) {
		try 
		{
			dao = new UserDAO();
			
			user = dao.findById(email);
			
			if(password.equals(passwordConfirmation) == false)
			{
				request.setAttribute("message", "Las contraseñas no son iguales.");
				
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
			else if(SecurityUtility.isPasswordStrong(password) == false)
			{
				request.setAttribute("message", "La contrasena debe tenr una logitud minima de 8 caracteres y contener al menos 1 minuscula, 1 mayuscula, 1 numero y un simbolo especial $@$!%*?&");
				
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
			else if(user != null) // El usuario ya existe 
			{
				request.setAttribute("message", "El usuario ya existe");
				
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
				return;
			}
			else
			{
				user = new UserValueObject();
				
				user.setEmail(email);
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setPassword(password);
				
				dao.create(user);
				
				request.setAttribute("message", "El usuario se ha registrado con exito");
				
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				return;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
					
			error = new ErrorValueObject();
			
			error.setMessage("Ocurrio un error al registrar usuario.");
			error.setDescription(ex.getMessage());
			error.setException(ex);
			
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		finally
		{
			if(dao != null) dao.closeConnection();
		}}else {
			error = new ErrorValueObject();
			
			error.setMessage("Error");
			error.setDescription("<h1>Introduce solo caracteres validos (no se aceptan: < > ' - </h1>");
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
	}
}

