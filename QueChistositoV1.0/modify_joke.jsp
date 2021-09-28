<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject"%>
<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.dao.JokesDAO"%>
<%@ page
	import= "mx.ipn.upiicsa.segsw.labicla.util.Utility" %>	
<%@ page import="java.util.List"%>

<%!
List<JokeValueObject> jokeList;
JokeValueObject joke;
JokeValueObject jokeToBeUpdated;
String value;
%>
	
<html>
<head>
<title>Que chistosito!</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/fondo.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="messages_panel.jsp" />

	<br><br><br>
	
	
	<%
	JokesDAO dao = null;
	JokeValueObject jokeValueObject = null;	
	UserValueObject user = (UserValueObject) request.getSession().getAttribute("user");
	jokeList = (List<JokeValueObject>) request.getAttribute("jokeList");
	
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
	jokeToBeUpdated = (JokeValueObject) request.getAttribute("jokeToBeUpdated");
	
	  value = "";
	if(jokeToBeUpdated != null)
	{
	%>
		<div class="container" style="background-color: rgba(0, 0, 0,0.5)">
			<div align="center"><br>
			<font color="white"><h2>Por favor capture la siguiente informacion</h2></font>
			<br></div>
			
		<form action="modify_joke.controller" method="POST">
		  
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label" name="email" style="color:white;" ></label>
		    <div class="col-sm-10">
		      <input type="text"  style="display: none;" name="id" class="form-control" id="id"  value="<%=jokeToBeUpdated.getId()%>" pattern="[A-Za-z0-9.#$%&]+" >
		    </div>
		  </div>
		  <%// <div name="id" id="id" style="display: none;"><%=jokeToBeUpdated.getId(</div> %>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label" name="email" style="color:white;" >Nombre</label>
		    <div class="col-sm-10">
		      <input type="text"  name="name" class="form-control" id="nombre"  value="<%=jokeToBeUpdated.getName()%>" pattern="[ A-Za-z0-9.#$%&\s]+" title="No se aceptan los caracteres:  < > ' - "  >
		    </div>
		  </div>
		  
		  <br>
		  
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label" style="color:white;">Categoria</label>
		    <div class="col-sm-10">
		    	<select name="category" id="inputcategory"  class="btn btn-dark">
    			<option value="inocente">Inocente</option>
    			<option value="negro">Negro</option>
    			<option value="meme">Rojo</option>	
  			</select>
		    </div>
		  </div>
		  
		  <br>
		  
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label" style="color:white;" >Palabras clave</label>
		    <div class="col-sm-10">
		      <input type="text" name="key_words" class="form-control" id="inputkeywords" pattern="[A-Za-z,.\s]+" value="<%=jokeToBeUpdated.getKeyWords()%>" title="No se aceptan los caracteres:  < > ' - ">
		    </div>
		  </div>
		  
		  <br>
		  
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label" style="color:white;" >Chiste</label>
		    <div class="col-sm-10">
		      <input type="text" name="content" class="form-control" id="inputcontent" pattern="[ A-Za-z0-9.#$%&?!,\s]+" value="<%=jokeToBeUpdated.getContent()%>" title="No se aceptan los caracteres:  < > ' - ">
		    </div>
		  </div>
		  
		  <br>
		  
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label" style="color:white;" >URL de imagen </label>
		    <div class="col-sm-10">
		      <input type="text" name="image" class="form-control" id="inputimg" pattern="[A-Za-z0-9.+=#$%&/,!?:¿¡\s]+" value="<%=jokeToBeUpdated.getImage()%>" title="No se aceptan los caracteres:  < > ' - ">
		    </div>
		  </div>
		  
		  <br>
		  
		  <div class="form-group" align="center">
		    <input type="submit" value="Modificar"  class="btn btn-primary">
              <br><br>
		  </div>
		</form>
		<%		
	}
%>
		</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
