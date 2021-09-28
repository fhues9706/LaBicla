<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>

<%!UserValueObject user;%>

<%
	user = (UserValueObject) session.getAttribute("user");

	if (user == null) // NO hay usuario firmado
	{
%>
   <div class="container-fluid" style="background-color: rgba(156, 237, 225, 0.85);">
    <h3 style="color:#000000; cursor: pointer;" onclick=location.href="/que-chistosito/main.jsp" title="Que chistosito"><b><i>Que Chistosito!</i></b></h3>
    <hr size="8px" color="black" />
	<div class="form-inline" style="text-align: left"> 
		<form action="authenticate_user.controller" method="POST">
            <nav class="navbar navbar-light">
                 <br>
                <label style="color:#FFFFFF; font-size:large; font-weight: bold;"><i style="color:#000000"><h3>Email:</h3></i></label>
			     <input type="text" style = "width:350px"; class="form-control" name="email" placeholder="Correo electronico" pattern="^[a-z0-9._%+]+@[a-z0-9.]+\.[a-z]{2,4}$" title="No se aceptan los caracteres:  < > ' - ">
			     <label style="color:#FFFFFF; font-size:large; font-weight: bold;"><i style="color:#000000"><h3>Password:</h3></i></label>
                 <input type="password" style = "width:350px"; class="form-control" name="password" placeholder="Contraseña" pattern="[A-Za-z0-9.#$@$!%*?&]{8,}" title="No se aceptan los caracteres:  < > ' - ">
			     <input type="submit" value="Entrar" class="btn btn-success" >
            </nav>
			     <br>	
                 <hr size="8px" color="black" />
		</form>
	</div>
	</div>
	<div class="form-inline" style="text-align: right;"> 
	<input type="submit" value="Menu" id="btn-menu" class="btn btn-primary right">
	</div>
           <nav class="nav" id="nav" style="top:  174px;"><!---->
                <ul class="menu">
                	<li><a class="menu_link" href="/que-chistosito">Inicio</a></li>
                    <li><a class="menu_link" href="get_blog_info.controller">Blog</a></li>
                    <li><a class="menu_link" href="register.jsp">Registro</a></li>
                </ul>
            </nav>
<%
	} 
	else // Hay usuario firmado
	{
%>

   <div class="container-fluid" style="background-color: rgba(156, 237, 225, 0.85);">
    <h3 style="color:#000000; cursor: pointer;" onclick=location.href="/que-chistosito/main.jsp" title="Que chistosito" "><b><i>Que Chistosito!</i></b></h3>
    <hr size="8px" color="black" />
	<div class="form-inline" style="text-align: right"> 
        <br>
        <center><label style="color:#ffffff; font-size:large; font-weight: bold;"><b><i style="color:#000000;">Hola <%=user.getName()%></i></b></label></center>
		<br>
        <hr size="8px" color="black" />
	</div>
	</div>
	<div class="form-inline" style="text-align: right;"> 
	<input type="submit" value="Menu" id="btn-menu" class="btn btn-primary">
	</div>
	
	
            <nav class="nav" id="nav" style="top:  168px;">
                <ul class="menu">
                    <li><a class="menu_link" href="/que-chistosito">Inicio</a></li>
                    <li><a class="menu_link" href="get_blog_info.controller">Blog</a></li>
                    <li><a class="menu_link" href="register_joke.jsp">Registrar chiste</a></li>
                    <li><a class="menu_link" href="logout.controller">Cerrar sesion</a></li>
                </ul>
            </nav>
    
<%
	}
%>

<br>