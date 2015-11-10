<%@ page language="java" import="java.util.*, org.is.webApp.*"%>

<jsp:useBean id="listaUsuarios"
	class="org.is.webApp.ListadoUsuarios" scope="session" />

<html>
<head>
<title>Modificación Usuarios</title>
</head>
<body bgcolor="#98BCDA">
	<h1>
		<center>Modificar Datos Usuario</center>
	</h1>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Usuario u = listaUsuarios.buscarUsuarios(id);
	%>
	<form method="post" action="modificarDatosUsuario.jsp">
		<input name="dni" type="hidden" value="<%= u.getDni()%>">
		<table align="center" cellpadding="2" cellspacing="2" border="1"
			width="25%" bgcolor="#dddddd">
			<tr>
				<th>Nombre:</th>
				<td><input name="nombre" type="text" value="<%=u.getNombre()%>"></td>
			</tr>
			<tr>
				<th>Primer Apellido:</th>
				<td><input name="apellido1" type="text" value="<%=u.getApellido1()%>"></td>
			</tr>
			<tr>
				<th>Segundo Apellido:</th>
				<td><input name="apellido2" type="text"
					value="<%=u.getApellido2()%>"></td>
			</tr>
			<tr>
				<th>Dirección:</th>
				<td><input name="direccion" type="text"
					value="<%=u.getDireccion()%>"></td>
			</tr>
			<tr>
				<th>Correo:</th>
				<td><input name="correo" type="text" value="<%=u.getCorreo()%>"></td>
			</tr>
			<tr>
				<th>DNI:</th>
				<td><input readonly="readonly" name="dni" type="text" value="<%=u.getDni()%>"></td>
			</tr>
			<tr>
				<th>Genero:</th>
				<td><input name="genero" type="text" value="<%=u.getGenero()%>"></td>
			</tr>
			<tr>
				<th>Puntuación:</th>
				<td><input name="puntuacion" type="text" value="<%=u.getPuntuacion()%>"></td>
			</tr>
			
			<tr>
				<th>Contraseña:</th>
				<td><input name="contrasena" type="password" readonly="readonly" value="<%=u.getContrasena()%>">
				</td>
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
				Usuarios [No se modificará]</a></b>
	</center>
</body>
</html>