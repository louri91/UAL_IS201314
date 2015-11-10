<html>
<head>
<title>Nuevo Usuario</title>
</head>
<body bgcolor="#98BCDA">
	<h1>
		<center>Dar de Alta Usuario</center>
	</h1>
	<form method="post" action="insertarUsuario.jsp">
		<table align="center" cellpadding="2" cellspacing="2" border="1"
			width="25%" bgcolor="#dddddd">
			<tr>
				<th>Nombre:</th>
				<td><input name="nombre" type="text"></td>
			</tr>
			<tr>
				<th>Primer Apellido:</th>
				<td><input name="apellido1" type="text"></td>
			</tr>
			<tr>
				<th>Segundo Apellido:</th>
				<td><input name="apellido2" type="text"></td>
			</tr>
			<tr>
				<th>Direccion:</th>
				<td><input name="direccion" type="text"></td>
			</tr>
			<tr>
				<th>Correo:</th>
				<td><input type="text" name="correo"> 
				</td>
			</tr>
			<tr>
				<th>DNI:</th>
				<td><input name="dni" type="text"></td>
			</tr>
			<tr>
				<th>Genero:</th>
				<td><input name="genero" type="radio" value ="Femenino" checked>Femenino<br>
				<input name="genero" type="radio" value = "Masculino">Masculino</td>
			</tr>
			<tr>
				<th>Puntuacion:</th>
				<td><input name="puntuacion" type="text"></td>
			</tr>
			<tr>
				<th>Contraseña:(mínimo 5 caracteres)</th>
				<td><input name="contrasena" type="password"></td>
			</tr>
			
			
		</table>
		<br>
		<center>
			<input name="pagemode" type="hidden" value="submit"> <input
				type="submit" value="Aceptar">
		</center>
		<hr>
	</form>
	<center>
		<b><a href="indexUsuario.jsp">Volver al listado de
				Usuarios (No se dara de Alta)</a></b>
	</center>
</body>
</html>