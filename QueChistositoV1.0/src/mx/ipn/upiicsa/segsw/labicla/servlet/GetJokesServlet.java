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

import mx.ipn.upiicsa.segsw.labicla.dao.JokesDAO;
import mx.ipn.upiicsa.segsw.labicla.util.ServletUtility;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/get_products.controller")
public class GetJokesServlet extends HttpServlet implements Servlet {
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
		ServletUtility.showRequestData(request);
		
		ErrorValueObject error = null;
		JokesDAO dao = null;
		
		List<JokeValueObject> jokeList = null;
		
		String criteria = request.getParameter("criteria");
		String metodo =request.getParameter("busqueda");
		
		//validacion para el campo criteria
		if(criteria.matches("[A-Za-z0-9.#$@$!%*?&]+")==true||criteria.matches("")) {
		if(metodo.equals("autor")) {
			if(Utility.containsAnEmptyValue(criteria))
			{
				criteria = "";
			}
			
			try 
			{
				dao = new JokesDAO();
				
				jokeList = dao.findByAuthor(criteria);
				
				request.setAttribute("jokeList", jokeList);
				
				RequestDispatcher rd = request.getRequestDispatcher("jokes.jsp");
				rd.forward(request, response);
				return;

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
						
				error = new ErrorValueObject();
				
				error.setMessage("Ocurrio un error al buscar productos.");
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
			
		}else if(metodo.equals("categoria")) {
			if(Utility.containsAnEmptyValue(criteria))
			{
				criteria = "";
			}
			
			try 
			{
				dao = new JokesDAO();
				
				jokeList = dao.findByCategory(criteria);
				
				request.setAttribute("jokeList", jokeList);
				
				RequestDispatcher rd = request.getRequestDispatcher("jokes.jsp");
				rd.forward(request, response);
				return;

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
						
				error = new ErrorValueObject();
				
				error.setMessage("Ocurrio un error al buscar productos.");
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
		}else
			if(Utility.containsAnEmptyValue(criteria))
			{
				criteria = "";
			}
			
			try 
			{
				dao = new JokesDAO();
				
				jokeList = dao.findByCriteria(criteria);
				
				request.setAttribute("jokeList", jokeList);
				
				RequestDispatcher rd = request.getRequestDispatcher("jokes.jsp");
				rd.forward(request, response);
				return;
	
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
						
				error = new ErrorValueObject();
				
				error.setMessage("Ocurrio un error al buscar productos.");
				error.setDescription(ex.getMessage());
				error.setException(ex);
				
				request.setAttribute("error", error);
				
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			finally
			{
				if(dao != null) dao.closeConnection();
			}}else {
				error = new ErrorValueObject();
				
				error.setMessage("Ah perro!!!");
				error.setDescription("<h1>Con que intentando hackearme desde mi campo de busqueda >:v</h1>");
				request.setAttribute("error", error);
				
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);

				return;
			}
	}
}
