<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina dei risultati</title>
</head>
<body>
<button type="button" onclick="location.href='searchForm.jsp'" style="width:120px;padding:5px;float:left; display: block;"> <<   Home</button>
<h2 align="center">Lista degli abitanti</h2>
	<table border="2" align="center" width="500">
		<thead>
			<tr>
				<td><strong>Nome</strong></td>
				<td><strong>Cognome</strong></td>
				<td></td>
			</tr>
		</thead>

		<%
			List<Abitante> listaDaServlet = (List<Abitante>) request.getAttribute("listAbitantiAttributeName");
			for (Abitante abitanteItem : listaDaServlet) {
		%>
		<tr>
			<td><%=abitanteItem.getNome()%></td>
			<td><%=abitanteItem.getCognome()%></td>
			<td width="100" align="center"><a
				href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante()%>">Dettaglio</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<div>
		<button type="button"
			onclick="location.href='PrepareInsertAbitanteServlet'"
			style="padding: 10px; width:300px; margin-left: auto; margin-right: auto; display: block;">Inserisci nuovo abitante</button>
	</div>
</body>
</html>