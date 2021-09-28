<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject"%>

<%@ page import="java.util.List"%>

<%!List<JokeValueObject> jokeproductList;
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
<%@ include file = "header.jsp" %>
	
	<%@ include file = "messages_panel.jsp" %>


	<%@ include file = "search_panel.jsp" %>

	<br>

	<%
		List<JokeValueObject> jokeList = (List<JokeValueObject>) request.getAttribute("jokeList");
		if(jokeList != null && jokeList.size() > 0)
		{
	%>

	<div class="container"  align="center"> 
	<h4><center>Chistes encontrados:  </center> </h4>
	<br>
	<table border="1" class="table table-dark table-hover">
		<tr align="center">
			<th>Nombre</th>
			<th>Categoria</th>
			<th>Autor</th>
			<th>Detalles</th>
			<th width="5%">&nbsp;</th>
			<th width="5%%">&nbsp;</th>
		</tr>

		<% 
		for(int i = 0;i < jokeList.size(); i++)
		{
			joke=jokeList.get(i);
		%>
		<tr align="center">
			<td class="table-primary"><%= joke.getName() %></td>
			<td class="table-danger"><%= joke.getCategory() %></td>
			<td class="table-primary"><%= joke.getJokeCreatorEmail() %></td>
			<td class="table-primary"><a href="get_product_detail.controller?id=<%= joke.getId() %>">Ver Chiste</a></td>
			
			<% if( user != null && (joke.getJokeCreatorEmail().equals(user.getEmail()) || user.getEmail().equals("admin@novalidserver.net") )) { %>
			
			<td class="table-danger"><a href="load_joke_to_be_modified.controller?id=<%= joke.getId() %>">Modificar</a></td>
			<td class="table-primary"><a href="delete_joke.controller?id=<%= joke.getId() %>">Eliminar</a></td>
			<% }else{ %>			
			<td class="table-danger">&nbsp;</td>
			<td class="table-primary">&nbsp;</td>
		<% 
			}%>		
		</tr>
		<% 
		}
%>
	</table></div>
	<% 
	}
	else
	{
%>

	<div class="container" style="background-color: rgba(0, 0, 0,0.5)" align="center">
	<br><br><br>
	<font color="white"><h2>No se encontraron chistes para <%= request.getParameter("criteria") %></h2></font>
	<br><br><br>
	</div>
	<%
		
	}
%>
	<br>
	<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>
