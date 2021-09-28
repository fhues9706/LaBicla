<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.util.Utility"%>

<%!
String message;
%>

<%
	message = (String) request.getAttribute("message");

	if (Utility.containsAnEmptyValue(message) == false) // Hay mensaje por mostrar
	{
%>
    <br>
	<div class="container" style="background-color: rgba(0, 0, 0,0.5)" align="center">
		<ul>
			<li><font color="white"><h2><%= message %></h2></font></li>
		</ul>
		
	</div>
<%
	} 
%>
