<%@ page language="java" import="java.util.*, org.is.webApp.*"%>

<jsp:useBean id="listaTorneos"
	class="org.is.webApp.ListadoTorneos" scope="session" />

<html>
<head>
<title>Nuevo Torneo</title>
</head>
<body bgcolor="#ffffee">
	<h1>
		<center>Dar de Alta Torneo</center>
	</h1>
	<table align="center" cellpadding="2" cellspacing="2" border="1"
		width="25%" bgcolor="#dddddd">
		<tr>
			<th>Nombre del torneo</th>
			<td><%=request.getParameter("nombre")%></td>
		</tr>
		<tr>
			<th>Numero minimo de jugadores</th>
			<td><%=request.getParameter("numMinimo")%></td>
		</tr>
		<tr>
			<th>Numero maximo de jugadores</th>
			<td><%=request.getParameter("numMaximo")%></td>
		</tr>
		<tr>
			<th>Tipo de mesa</th>
			<td><%=request.getParameter("mesa")%></td>
		</tr>
		<tr>
			<th>Clasificatoria</th>
			<td><%=request.getParameter("clasificacion")%></td>
		</tr>
		<tr>
			<th>Premio</th>
			<td><%=request.getParameter("premio")%></td>
		</tr>
		<tr>
			<th>Jugadores inscritos</th>
			<td><%=request.getParameter("jugadores")%></td>
		</tr>
	</table>
	<%
		int codeError = 0; //no hay error
		String nombre = request.getParameter("nombre");
		String numMinimo = request.getParameter("numMinimo");
		String numMaximo = request.getParameter("numMaximo");
		String tipoMesa = request.getParameter("mesa");
		Boolean clasificatoria = Boolean.parseBoolean(request.getParameter("clasificacion"));
		String premio = request.getParameter("premio");
		String jugadores = request.getParameter("jugadores");
		
		if ((nombre.equals("")) || (nombre.length() > 30))
			codeError = 1;
		else if ((numMinimo.equals("")) || (numMinimo.contains(" ")))
			codeError = 2;
		else if ((numMaximo.equals("")))
			codeError = 3;
		else if ((premio.equals("")) || (premio.contains(" ")))
			codeError = 4;

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
			<font color="#cc0000">El número mínimo de jugadores no puede ser negativo o 0</font>
		</h2>
	</center>

	<%
		break;
		case 3:
	%>
	<center>
		<h2>
			<font color="#cc0000">El número máximo de jugadores no puede ser negativo o 0</font>
		</h2>
	</center>
	<%
		break;
		case 4:
	%>
	<center>
		<h2>
			<font color="#cc0000">Campo premio vacío o contiene espacios</font>
		</h2>
	</center>
	<%
		break;
		case 5:
	%>
	<center>
		<h2>
			<font color="#cc000">No se ha podido insertar el registro</font>
		</h2>
	</center>
	<%
		break;
		default:
			Torneo t = new Torneo(nombre,Integer.parseInt(numMinimo),Integer.parseInt(numMaximo),tipoMesa,clasificatoria,premio,jugadores);
			int insercionCorrecta = listaTorneos.insertarTorneo(t);
			if (insercionCorrecta == 1) {
	%>
	<center>
		<h2>
			<font color="#00cc00">Nuevo torneo creado</font>
		</h2>
	</center>

	<%
		} else {
	%>
	<center>
		<h2>
			<font color="#cc0000">El torneo ya existe.</font>
		</h2>
	</center>
	<%
		}
		}
	%>
	<hr>
	<center>
		<b><a href="indexTorneo.jsp">Volver al listado de
				Torneos</a></b>
	</center>
</body>
</html>