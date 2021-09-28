<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
	import="mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject"%>
	
	
<html>
<head>
<title>Que chistosito! Team jsp</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/fondo.css" type="text/css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/team.css">

</head>
<body>

	<jsp:include page="header.jsp" />
    <hr size="8px" color="black" />
    <section style="margin-top:46px; padding:1px 1px 1px 1px; background-color: rgba(99, 110, 197, 0.73);">
            <center><h4 style="color:#ffffff"><i>Presentacion del equipo desarrollador</i></h4></center>
    </section> 
	<br>
	<div class="container"  align="center">
	<table border="1" class="table table-dark table-hover">
<tr>
<td ><img src="images/francisco.jpeg" alt="Image" style="width:300px; heigth:350px;"; class="img-fluid rounded-circle tres" data-toggle="tooltip" title="Huesca Cienfuegos Francisco" ></td>
<td ><img src="images/aulp.jpg" alt="Image" style="width:300px; heigth:350px;"; class="img-fluid rounded-circle dos" data-toggle="tooltip" title="López Patricio Angel Uriel" ></td>
<td ><img src="images/z(2).jpg" alt="Image"  class="img-fluid rounded-circle cuatro" data-toggle="tooltip" title="Miranda Flores Salvador" ></td>
</tr>

<tr>
<td align="center">

	<p class="uno tres" style="background-color: rgba(178, 208, 144, 0.62);">
	Huesca Cienfuegos Francisco
					<br>6to semestre
					<br>Me gusta mucho la ciencia y la tecnología						
					<br>Uno de mis pasatiempos favoritos es escuchar música, me encanta descubrir nuevos géneros o artistas de mi gusto y también me gusta perder el tiempo viendo series y películas
    </p>
</td>

<td align="center">

	<p class="uno dos" style="background-color: rgba(208, 176, 144, 0.62);"> 
        Mi nombre es Ángel Uriel López Patricio, estoy en 4to semestre de la carrera de ingeniería en informática en UPIICSA.
					<br>Me gusta la tecnología y los superhéroes, uno de mis objetivos a futuro es ser como lron Man y combatir el crimen mediante el uso de la tecnología.
					<br>Uno de mis pasatiempos es ver series y películas, hacer algo de ejercicio y comprar figuras de colección con  mi hermano.
   </p>
</td>
<td align="center">
	
	<p class="uno" style="background-color: rgba(144, 191, 208, 0.62);">
        Miranda Flores Salvador
					<br>5to semestre. 
					<br>Ingeniería en informática. 
					<br>Me gusta mucho los conocimientos sobre la tecnología, las culturas de diferentes países y me gusta la literatura de ciencia ficción. 
					<br>Uno de mis pasatiempos es practicar deporte de baloncesto y lo práctico de vez en cuando 2 o 3 veces por semana.
					<br>Me gustan los videojuegos móviles y uno de ellos el Fire Emblem Heroes.
    </p>
</td>
</tr>
</table></div>
	
	<br>
	<jsp:include page="footer.jsp" />	
</body>
</html>