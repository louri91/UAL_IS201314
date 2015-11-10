<%@ page language="java" import="java.util.*, org.is.webApp.*"%>

<jsp:useBean id="listaTorneos"
	class="org.is.webApp.ListadoTorneos" scope="session" />

<html>
<head>
<title>Torneo eliminado</title>
</head>
<body bgcolor="#98BCDA">
	<h1>
		<center>Torneo eliminado</center>
	</h1>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Torneo t = listaTorneos.buscarTorneo(id);
	listaTorneos.borrarTorneo(t);
	
	%>
	<form method="post" action="modificarDatosTorneo.jsp">
		<input name="id" type="hidden" value="<%= t.getIdTorneo()%>">
		<table align="center" cellpadding="2" cellspacing="2" border="1"
			width="25%" bgcolor="#dddddd">
			<tr>
				<th>Nombre:</th>
				<td><input readonly="readonly" name="nombre" type="text" value="<%=t.getNombre()%>"></td>
			</tr>
			<tr>
				<th>Numero mínimo de jugadores:</th>
				<td><input readonly="readonly" name="numMinimo" type="text" value="<%=t.getNumMinimo()%>"></td>
			</tr>
			<tr>
				<th>Numero máximo de jugadores:</th>
				<td><input readonly="readonly" name="numMaximo" type="text"
					value="<%=t.getNumMaximo()%>"></td>
			</tr>
			<tr>
				<th>Tipo de Mesa:</th>
				<td><input readonly="readonly" name="mesa" type="text"
					value="<%=t.getTipoMesa()%>"></td>
			</tr>
			<tr>
				<th>Clasificatoria:</th>
				<td><input readonly="readonly" name="clasificacion" type="text" value="<%=t.isClasificatoria()%>"></td>
			</tr>
			<tr>
				<th>Premio:</th>
				<td><input readonly="readonly" name="premio" type="text" value="<%=t.getPremio()%>"></td>
			</tr>
			<tr>
				<th>Jugadores inscritos:</th>
				<td><input readonly="readonly" name="jugadores" type="text" value="<%=t.getJugadores()%>"></td>
			</tr>
		</table>
		<br>
		<hr>
	</form>
	<center>
		<b><a href="indexTorneo.jsp">Volver al listado de
				Torneos</a></b>
	</center>
</body>
</html>