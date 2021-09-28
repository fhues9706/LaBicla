<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.JokeValueObject"%>

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
    
	<%/*recuerda que te quedaste aqui cabiandole el estilo al form para que se vea mas mamalon*/ %>
    <section style="margin-top:46px; padding:1px 1px 1px 1px; background-color: rgba(99, 110, 197, 0.73);">
            <center><h4 style="color:#ffffff"><i>¿Quieres ser mienbro de nuestra pagina?</i></h4></center>
    </section> 
    <br>
	<div class="container" style="background-color: rgba(0, 0, 0,0.5)">
		<div align="center"><br>
		<font color="white"><h2>Por favor capture la siguiente informacion</h2></font>
		<br></div>
		
	<form action="register_user.controller" method="POST">
	  
	  <div class="form-group row">
	    <label for="inputEmail3" class="col-sm-2 col-form-label" name="email" style="color:white;" >Email</label>
	    <div class="col-sm-10">
	      <input type="text"  name="email" class="form-control" id="inputEmail3" title="No se aceptan los caracteres:  < > ' - " placeholder="Email" placeholder="Ingresa tu email" pattern="^[a-z0-9._%+]+@[a-z0-9.]+\.[a-z]{2,4}$" >
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label for="inputname" class="col-sm-2 col-form-label" style="color:white;" >Nombre</label>
	    <div class="col-sm-10">
	      <input type="text" name="firstname" class="form-control" id="inputname" title="No se aceptan los caracteres:  < > ' - " pattern="[ A-Za-z]+" placeholder="Ingresa tu nombre">
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label for="inputsurname" class="col-sm-2 col-form-label" style="color:white;" >Apellidos</label>
	    <div class="col-sm-10">
	      <input type="text" name="lastname" class="form-control" id="inputsurname" title="No se aceptan los caracteres:  < > ' - " pattern="[ A-Za-z]+" placeholder="Ingresa tus apellidos">
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label for="inputpwd" class="col-sm-2 col-form-label" style="color:white;" >Password</label>
	    <div class="col-sm-10">
	      <input type="password" name="password" class="form-control" id="inputpwd" title="No se aceptan los caracteres:  < > ' - " pattern="[A-Za-z0-9.#$%&?!]+" placeholder="Ingresa una contraseña">
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label for="inputpwdc" class="col-sm-2 col-form-label" style="color:white;" >Password (Confirmacion) </label>
	    <div class="col-sm-10">
	      <input type="password" name="password-confirmation" class="form-control" title="No se aceptan los caracteres:  < > ' - " id="inputpwdc" pattern="[A-Za-z0-9.#$%&?!]+" placeholder="Confirma tu contraseña">
	    </div>
	  </div>
	  <br>
	  <div class="form-group" align="center">
	    <input type="submit" value="Registar"  class="btn btn-primary">
      <br><br>
	  </div>
	</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
