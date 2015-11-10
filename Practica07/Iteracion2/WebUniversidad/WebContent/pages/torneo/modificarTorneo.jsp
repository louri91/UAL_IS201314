<%@ page language="java" import="java.util.*, org.is.webApp.*"%>

<jsp:useBean id="listaTorneos"
	class="org.is.webApp.ListadoTorneos" scope="session" />

<html>
<head>
<title>Modificación Torneo</title>
</head>
<body bgcolor="#98BCDA">
	<h1>
		<center>Modificar Datos Torneo</center>
	</h1>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Torneo t = listaTorneos.buscarTorneo(id);
	%>
	<form method="post" action="modificarDatosTorneo.jsp">
		<input name="id" type="hidden" value="<%= t.getIdTorneo()%>">
		<table align="center" cellpadding="2" cellspacing="2" border="1"
			width="25%" bgcolor="#dddddd">
			<tr>
				<th>Nombre:</th>
				<td><input name="nombre" type="text" value="<%=t.getNombre()%>"></td>
			</tr>
			<tr>
				<th>Numero mínimo de jugadores:</th>
				<td><input name="numMinimo" type="text" value="<%=t.getNumMinimo()%>"></td>
			</tr>
			<tr>
				<th>Numero máximo de jugadores:</th>
				<td><input name="numMaximo" type="text"
					value="<%=t.getNumMaximo()%>"></td>
			</tr>
			<tr>
				<th>Tipo de Mesa:</th>
				<td><input name="mesa" type="text"
					value="<%=t.getTipoMesa()%>"></td>
			</tr>
			<tr>
				<th>Clasificatoria:</th>
				<td><input name="clasificacion" type="text" value="<%=t.isClasificatoria()%>"></td>
			</tr>
			<tr>
				<th>Premio:</th>
				<td><input name="premio" type="text" value="<%=t.getPremio()%>"></td>
			</tr>
			<tr>
				<th>Jugadores inscritos:</th>
				<td><input name="jugadores" type="text" value="<%=t.getJugadores()%>"></td>
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
				Torneos [No se modificará]</a></b>
	</center>
</body>
</html>