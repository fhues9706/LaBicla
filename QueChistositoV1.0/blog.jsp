<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject"%>
<%@ page import="mx.ipn.upiicsa.segsw.labicla.util.Utility"%>
<%@ page import="java.util.List"%>

<%!
List<BlogEntryValueObject> blogEntryList;
BlogEntryValueObject blogEntry;
BlogEntryValueObject blogEntryToBeUpdated;
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

	<br>
	<div class="container">
		<section style="margin-top:46px; padding:1px 1px 1px 1px; background-color: rgba(99, 110, 197, 0.73);">
	        <center><h4 style="color:#ffffff"><i>Bienvenido al blog principal de <b>Que Chistosito!</b></i></h4></center>
	    </section>  
	    <br>
			<div>
				<form action="get_blog_info.controller" method="GET">
					<input type="text" style = "width:350px"; class="form-control" name="criteria" placeholder="Tema" pattern="[ A-Za-z0-9]+"> 
			        <br>
					<input type="submit" value="Buscar" class="btn btn-success">
				</form>
			</div>
	
		<br>
	
		<% 
		
	    blogEntryList = (List<BlogEntryValueObject>) request.getAttribute("blogEntryList");
		if(blogEntryList != null && blogEntryList.size() > 0)
		{
	    %>
	
		<table border="1" class="table table-dark table-hover">
			<tr align="center">
				<th width="15%">Usuario</th>
				<th width="60%">Entrada</th>
				<th width="15%">Fecha</th>
				<% 
				
				System.out.println("blog.jsp - User - " + user);
				
				if( user != null) { 
						
						%>
				<th width="5%">&nbsp;</th>
				<th width="5%">&nbsp;</th>
				<% } %>
			</tr>
	
			<% 
			for(int i = 0;i < blogEntryList.size(); i++)
			{
				blogEntry = blogEntryList.get(i);
	%>
			<tr align="center">
				<td class="table-primary"><%= blogEntry.getUserEmail() %></td>
				<td class="table-danger"><div><%= blogEntry.getValue() %></div></td>
				<td class="table-primary"><%= blogEntry.getRegistrationDate() %></td>
				
				<% if( user != null && (blogEntry.getUserEmail().equals(user.getEmail()) || user.getEmail().equals("admin@novalidserver.net") )) { %>
				
				<td class="table-danger"><a href="load_blog_entry_to_be_modified.controller?id=<%= blogEntry.getId() %>">Modify</a></td>
				<td class="table-primary"><a href="delete_blog_entry.controller?id=<%= blogEntry.getId() %>">Delete</a></td>
				<% }else{ %>			
				<td class="table-danger">&nbsp;</td>
				<td class="table-primary">&nbsp;</td>
			<% 
			}%>
				</tr><%
			}
	%>
		</table>
		<% 
		}
		else if(Utility.containsAnEmptyValue(request.getParameter("criteria")) == false)
		{
	%>
		<div class="container" style="background-color: rgba(0, 0, 0,0.5)" align="center">
		<br><br><br>
		<font color="white"><h2>No se encontraron info para <%= request.getParameter("criteria") %></h2></font>
		<br><br><br>
		</div>
		<%		
		}
	%>
		<br>
	
	<%
		if(user != null) 
		{
	%>	
		<div>
			<% 
			  blogEntryToBeUpdated = (BlogEntryValueObject) request.getAttribute("blogEntryToBeUpdated");
			
			  value = "";
			  if(blogEntryToBeUpdated != null)
			  {
				  value = blogEntryToBeUpdated.getValue();
			%>
	                <H4 style="color:#000000"><i>Modificar comentario</i></H4>
	            <br>
				<form action="modify_blog_entry.controller" method="POST">
				<input type="hidden" name="id" value="<%=blogEntryToBeUpdated.getId()%>" style = "font-family:courier,arial,helvética;">
				
			<% } else { %>
	                <H4 style="color:#000000"><i>Agregar comentario</i></H4>
	            <br>
				<form action="register_blog_entry.controller"  method="POST">
			<% } %>
			
				<textarea name="blog-entry-value" rows="5" cols="80"  placeholder="Ingresa tu comentario..." pattern="[A-Za-z0-9.#$@$!%*?&_,¿¡]" ><%= value %></textarea>
	            <br><br>
				<input type="submit" value="enviar" class="btn btn-success">
			</form>
		</div>
	<%
		}%>
	</div>	
		<br>
	<%@ include file = "footer.jsp" %>
</body>
</html>
