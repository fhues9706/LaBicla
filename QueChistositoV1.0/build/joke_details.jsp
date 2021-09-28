<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject"%>

<%!JokeValueObject joke;%>

<html lang="es">
<head>
<title>Que chistosito!</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/fondo.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="utf-8">
</head>
<body>

	<%@ include file = "header.jsp" %>
	<%@ include file = "messages_panel.jsp" %>

	

	<%@ include file = "search_panel.jsp" %>

	<br>

	<br>

	<%
		JokeValueObject joke = (JokeValueObject) request.getAttribute("joke");
			if (joke != null) {
	%>
	
	<div class="container" align="center" style="background-color: rgba(255, 255, 255,0.5)">
		<table class="table table-borderless";>
			<tr">
			<th><h2> <center><%=joke.getName()%></center> </h2></th>
			</tr>

			<tr >
			<th><h6><center> Subido por: <%=joke.getJokeCreatorEmail()%></center></h6></th>
			</tr>

			<tr ">
			<th><h6><center>Categoria: <%=joke.getCategory()%></center></h6></th>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
			<th><p class="lead"><center><%=joke.getContent()%></center></p></th>
			</tr>

			<tr>
			<th><div align="center" ><img src="<%=joke.getImage()%>" class ="rounded" alt="No se encontro la imagen" style="width:250px"/></div></th>
			</tr>	
		</table><br>
	</div>

	<%
		} else {
	%>
	<div class="container" style="background-color: rgba(0, 0, 0,0.5)" align="center">
		<br><br><br>
		<font color="white"><h2>No se encontr&oacute; el chiste indicado con id = <%=request.getParameter("id") %></h2></font>
		<br><br><br>
	</div>

	<%
		}
	%>

	<%@ include file = "footer.jsp" %>
</body>
</html>
