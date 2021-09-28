<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject"%>

<%!
ErrorValueObject error;
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



<%@ include file = "search_panel.jsp" %>

<br>

<%
	error = (ErrorValueObject) request.getAttribute("error");
	if( error != null)
	{
%>

<div class="container" style="background-color: rgba(0, 0, 0,0.5)"  align="center"><br>
	<br><br><br>
		<font color="white"><h1><%=error.getMessage() %></h1></font>
	<br>
		<font color="white"><h3><%=error.getDescription() %></h3></font>
	<br><br><br>
</div>


<%
		if( error.getException() != null)
		{
%>
<div class="container" style="background-color: rgba(0, 0, 0,0.5)"  align="center"><br>
<br>
<font color="white"><h3>Exception</h3></font>
<font color="white"><p>Causa: <%=error.getException().getCause() %></p></font>

<font color="white"><h4>StackTrace</h4></font>
<font color="white"><p><%=error.getException() %></p></font>
</div>
<%
			StackTraceElement[] stArray = error.getException().getStackTrace();
			for(int i=0; i < stArray.length; i++)
			{
%>
				<p><%=stArray[i] %><p>

<%
			}
		}	
	}
	else
	{
%>
<h1>No hay informaci&oacute;n del error a mostrar</h1>
<% 
	}
%>
<br>
<br>


<%@ include file = "footer.jsp" %>
</body>
</html>