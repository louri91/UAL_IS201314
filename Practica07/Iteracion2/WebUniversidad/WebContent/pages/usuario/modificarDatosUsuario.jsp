<%@ page language="java" import="java.util.*, org.is.webApp.*"%>

<jsp:useBean id="listaUsuarios"
	class="org.is.webApp.ListadoUsuarios" scope="session" />

<html>
<head>
<title>Modificación Usuario</title>
</head>
<body bgcolor="#98BCDA">
	<h1>
		<center>Modificar Datos Usuario</center>
	</h1>
	<table align="center" cellpadding="2" cellspacing="2" border="1"
		width="25%" bgcolor="#dddddd">
		<tr>
			<th>Nombre:</th>
			<td><%=request.getParameter("nombre")%></td>
		</tr>
		<tr>
			<th>Primer Apellido</th>
			<td><%=request.getParameter("apellido1")%></td>
		</tr>
		<tr>
			<th>Segundo Apellido</th>
			<td><%=request.getParameter("apellido2")%></td>
		</tr>
		<tr>
			<th>Direccion</th>
			<td><%=request.getParameter("direccion")%></td>
		</tr>
		<tr>
			<th>Correo</th>
			<td><%=request.getParameter("correo")%></td>
		</tr>
		<tr>
			<th>DNI</th>
			<td><%=request.getParameter("dni")%></td>
		</tr>
		<tr>
			<th>Genero</th>
			<td><%=request.getParameter("genero")%></td>
		</tr>
		<tr>
			<th>Puntuacion</th>
			<td><%=request.getParameter("puntuacion")%></td>
		</tr>
		<tr>
			<th>Contrasena</th>
			<td><%=request.getParameter("contrasena") %></td>
		</tr>

	</table>
	<%
		int codeError = 0; //no hay error
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String direccion = request.getParameter("direccion");
		String correo = request.getParameter("correo");
		String dni = request.getParameter("dni");
		String genero = request.getParameter("genero");
		String puntuacion = request.getParameter("puntuacion");
		String contrasena = request.getParameter("contrasena");
		
		if ((nombre.equals("")) || (nombre.length() > 30))
			codeError = 1;
		else if ((apellido1.equals("")) || (apellido1.length() > 30))
			codeError = 2;
		else if ((apellido2.equals("")) || (apellido2.length() > 30))
			codeError = 3;
		else if ((direccion.equals("")) || (direccion.length() > 40))
			codeError = 4;
		else if ((correo.equals("")) || (correo.length() > 50))
			codeError = 5;
		else if ((dni.equals("")) || (dni.length() > 9))
			codeError = 6;

		switch (codeError) {
		case 1:
	%>
	<center>
		<h2>
			<font color="#cc0000">Nombre vacio o demasiado largo
				(máximo 30 caracteres)</font>
		</h2>
	</center>
	<%
		break;
		case 2:
	%>
	<center>
		<h2>
			<font color="#cc0000">Primer apellido vacio o demasiado largo
				(máximo 30 caracteres)</font>		
		</h2>
	</center>

	<%
		break;
		case 3:
	%>
	<center>
		<h2>
			<font color="#cc0000">Segundo apellido vacio o demasiado largo
				(máximo 30 caracteres)</font>
		</h2>
	</center>
	<%
		break;
		case 4:
	%>
	<center>
		<h2>
			<font color="#cc0000">Dirección vacia o demasiado larga
				(máximo 40 caracteres)</font>		</h2>
	</center>
	<%
		break;
		case 5:
	%>
	<center>
		<h2>
			<font color="#cc0000">Correo vacio o demasiado largo
				(máximo 50 caracteres)</font>		</h2>
	</center>
	<%
		break;
		case 6:
			%>
			<center>
				<h2>
					<font color="#cc0000">DNI vacio</font>	
				</h2>
			</center>
			<%
		break;
			
		default:
			
			Usuario u = new Usuario(nombre,apellido1,apellido2,direccion,correo,dni,genero,puntuacion,contrasena);
			int modificacionCorrecta = listaUsuarios.modificarUsuario(u);
			System.out.print("PEPITO");
			if (modificacionCorrecta == 1) {
	%>
	<center>
		<h2>
			<font color="#00cc00">Nuevo usuario creado</font>
		</h2>
	</center>

	<%
		}
		}
	%>
	<hr>
	<center>
		<b><a href="indexUsuario.jsp">Volver al listado de
				Usuarios</a></b>
	</center>
</body>
</html>