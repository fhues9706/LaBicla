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
	
    <section style="margin-top:46px; padding:1px 1px 1px 1px; background-color: rgba(99, 110, 197, 0.73);">
        <center><h4 style="color:#ffffff"><i>Haz tu aportacion aqui</i></h4></center>
    </section> 
    <br>
	<%/*recuerda que te quedaste aqui cabiandole el estilo al form para que se vea mas mamalon*/ %>
	<div class="container" style="background-color: rgba(0, 0, 0,0.5)">
		<div align="center"><br>
		<font color="white"><h2>Por favor capture la siguiente informacion</h2></font>
		<br></div>
		
	<form action="register_joke.controller" method="POST">
	  
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label" name="email" style="color:white;" >Nombre</label>
	    <div class="col-sm-10">
	      <input type="text"  name="name" class="form-control" id="nombre"  placeholder="Nombre del chiste" pattern="[ A-Za-z0-9.#$%&?!,\s¿¡]+" title="No se aceptan los caracteres:  < > ' - " >
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label" style="color:white;">Categoria</label>
	    <div class="col-sm-10">
	      <select name="category" id="category"  class="btn btn-dark">
                
    			<option value="inocente">Inocente</option>
    			<option value="negro">Negro</option>
    			<option value="rojo">Rojo</option>	
  			</select>
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label" style="color:white;" >Palabras clave</label>
	    <div class="col-sm-10">
	      <input type="text" name="key_words" class="form-control" id="inputkeywords" pattern="[A-Za-z,.\s]+" placeholder="Palabras clave del chiste" title="No se aceptan los caracteres:  < > ' - ">
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label" style="color:white;" >Chiste</label>
	    <div class="col-sm-10">
	      <input type="text" name="content" class="form-control" id="inputcontent" pattern="[ A-Za-z0-9.#$%&?!,\s¿¡]+" placeholder="Contenido del chiste..." title="No se aceptan los caracteres:  < > ' - ">
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group row">
	    <label  class="col-sm-2 col-form-label" style="color:white;" >URL de imagen </label>
	    <div class="col-sm-10">
	      <input type="text" name="image" class="form-control" id="inputimg" pattern="[A-Za-z0-9.+=#$%&/,!?:]+" placeholder="http://imagen.jpg" title="No se aceptan los caracteres:  < > ' - ">
	    </div>
	  </div>
	  
	  <br>
	  
	  <div class="form-group" align="center">
	    <input type="submit" value="Registar"  class="btn btn-primary">
	  </div>
        <br>
	</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
