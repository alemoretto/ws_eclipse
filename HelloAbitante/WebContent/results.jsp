<%@page import="java.util.List"%>
<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina dei risultati</title>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<link rel="stylesheet" type="text/css" href="myCSS.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<h2 align="center">Lista degli abitanti</h2>
<div class="container">
	<table class="table" border="2" align="center" width="500">
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
	</div>
	<br>
	<div>
		<button type="button"
			onclick="location.href='PrepareInsertAbitanteServlet'"
			style="padding: 10px; width:300px; margin-left: auto; margin-right: auto; display: block;">Inserisci nuovo abitante</button>
	</div>
	<button type="button" onclick="location.href='searchForm.jsp'" style="width:120px;padding:5px;float:left; display: block;"> <<   Home</button>
</body>
</html>