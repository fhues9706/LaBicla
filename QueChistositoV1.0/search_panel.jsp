
	<div class="container" class="dropdown-menu"><br>
		<form class="in-line" action="get_products.controller" method="POST">
			<select placeholder="Buscar por.." name="busqueda" id="busqueda" class="btn btn-secondary" >
                <option hidden value="">Buscar por....</option>
                <option value="nombre">Nombre</option>
                <option value="categoria">Categoria</option>	
    			<option value="autor">Autor</option>
  			</select>
            <br><br>
			<input type="text" name="criteria" placeholder="Escribe la referencia de la categoria seleccionada..." size="50" class="form-control" pattern="[A-Za-z0-9.#$@$!%*?&]+" title="No se aceptan los caracteres:  < > ' - " >
            <br>
			<input type="submit" value="Buscar"  class="btn btn-primary">
            <br>
		</form>
	</div>