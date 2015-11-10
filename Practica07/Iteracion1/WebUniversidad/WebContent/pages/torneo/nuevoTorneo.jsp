<html>
<head>
<title>Nuevo Torneo</title>
</head>
<body bgcolor="#98BCDA">
	<h1>
		<center>Dar de Alta Torneo</center>
	</h1>
	<form method="post" action="insertarTorneo.jsp">
			<table align="center" cellpadding="2" cellspacing="2" border="1"
			width="25%" bgcolor="#dddddd">
			<tr>
				<th>Nombre del torneo:</th>
				<td><input name="nombre" type="text"></td>
			</tr>
			<tr>
				<th>Numero minimo de jugadores</th>
				<td><input name="numMinimo" type="text"></td>
			</tr>
			<tr>
				<th>Numero maximo de jugadores</th>
				<td><input name="numMaximo" type="text"></td>
			</tr>
			<tr>
				<th>Tipo de mesa:</th>
				<td><input type="radio" name="mesa" value="Mesa10">Mesa larga (10 jugadores) 
				<br><input type="radio" name="mesa" value="Mesa5" checked>Mesa corta (5 jugadores) 
				</td>
			</tr>
			<tr>
				<th>Clasificatoria:</th>
				<td><input type="radio" name="clasificacion" value="True">Sí 
				<br><input type="radio" name="clasificacion" value="False" checked>No 
				</td>
			</tr>
			<tr>
				<th>Premio:</th>
				<td><input name="premio" type="text"></td>
			</tr>
			<tr>
				<th>Jugadores inscritos:</th>
				<td><input name="jugadores" type="text"></td>
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
		<b><a href="indexTorneo.jsp">Volver al listado de
				Torneo (No se dara de Alta)</a></b>
	</center>
</body>
</html>