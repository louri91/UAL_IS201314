<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, org.is.webApp.*"%>
    
<jsp:useBean id="listaTorneos"
	class="org.is.webApp.ListadoTorneos" scope="session" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Torneos</title>
</head>
<body bgcolor= "#98BCDA">
	<h1>
		<center>Gestión Torneos</center>
	</h1>

	<%
		ArrayList<Torneo> torneosLeidos = listaTorneos.getListaTorneos();
%>
	Total Torneos:
	<%= torneosLeidos.size() %>
	<%            
            if (listaTorneos.getListaTorneos()!= null) {
                if (listaTorneos.getListaTorneos().size () > 0) {
%>
	<table align="center" cellpadding="2" cellspacing="2" border="1"
		width="60%" bgcolor="#dddddd">
		<tr>
			<th>Nombre del torneo</th>
			<th>Numero minimo de jugadores</th>
			<th>Numero maximo de jugadores</th>
			<th>Tipo de mesa</th>
			<th>Clasificatoria</th>
			<th>Premio</th>
			<th>Jugadores inscritos</th>
		</tr>
		<%
        			for (int i = 0; i < listaTorneos.getListaTorneos().size(); i++) {
        				Torneo t = listaTorneos.getListaTorneos().get(i);
%>
		<tr>
			<td><%= t.getNombre() %></td>
			<td><%= t.getNumMinimo() %></td>
			<td><%= t.getNumMaximo() %></td>
			<td><%= t.getTipoMesa() %></td>
			<td><%= t.isClasificatoria()%></td>
			<td><%= t.getPremio() %></td>
			<td><%= t.getJugadores() %></td>
	
			<td align="center">
			<a href="modificarTorneo.jsp?id=<%= t.getIdTorneo() %>">Modificar</a>
			<a href="eliminarTorneo.jsp?id=<%=t.getIdTorneo() %>">Eliminar</td>
		</tr>
		<%
                    }
                }
            }
%>
	</table>
	<br>
	<hr>

		<b><a href="nuevoTorneo.jsp">Añadir nuevo torneo</a></b><br>
		<b><a href="../../index.jsp">Volver a la Pagina Principal</a></b>
</body>
</html>