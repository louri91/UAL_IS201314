<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, org.is.webApp.*"%>
    
<jsp:useBean id="listaUsuarios"
	class="org.is.webApp.ListadoUsuarios" scope="session" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body bgcolor= "#98BCDA">
	<h1>
		<center>Gestión Usuarios</center>
	</h1>

	<%
		ArrayList<Usuario> usuariosLeidos = listaUsuarios.getListaUsuarios();
%>
	Total Usuarios:
	<%= usuariosLeidos.size() %>
	<%            
            if (listaUsuarios.getListaUsuarios()!= null) {
                if (listaUsuarios.getListaUsuarios().size () > 0) {
%>
	<table align="center" cellpadding="2" cellspacing="2" border="1"
		width="60%" bgcolor="#dddddd">
		<tr>
			<th>Nombre</th>
			<th>Primer Apellido</th>
			<th>Segundo Apellido</th>
			<th>Direccion</th>
			<th>Correo</th>
			<th>DNI</th>
			<th>Genero</th>
			<th>Puntuacion</th>
		</tr>
		<%
        			for (int i = 0; i < listaUsuarios.getListaUsuarios().size(); i++) {
        				Usuario u = listaUsuarios.getListaUsuarios().get(i);
%>
		<tr>
			<td><%= u.getNombre() %></td>
			<td><%= u.getApellido1() %></td>
			<td><%= u.getApellido2() %></td>
			<td><%= u.getDireccion() %></td>
			<td><%= u.getCorreo() %></td>
			<td><%= u.getDni()%></td>
			<td><%= u.getGenero()%></td>
			<td><%= u.getPuntuacion()%></td>
		
	
			<td align="center">
			<a href="modificarUsuario.jsp?id=<%= u.getIdUsuario() %>">Modificar</a>
			<a href="eliminarUsuario.jsp?id=<%=u.getIdUsuario() %>">Eliminar</a></td>
		</tr>
		<%
                    }
                }
            }
%>
	</table>
	<br>
	<hr>

		<b><a href="nuevoUsuario.jsp">Añadir nuevo usuario</a></b><br>
		<b><a href="../../index.jsp">Volver a la Pagina Principal</a></b>
</body>
</html>