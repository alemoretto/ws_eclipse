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
	<table border="2" align="center">
		<thead>
			<tr>
				<td>Colonna Nome</td>
				<td>Colonna Cognome</td>
				<td>Azione</td>
			</tr>
		</thead>
		
		<%
					List<Abitante> listaDaServlet = (List<Abitante>)request.getAttribute("listAbitantiAttributeName");
							for(Abitante abitanteItem : listaDaServlet){
				%>
				<tr>
					<td><%=abitanteItem.getNome() %></td>
					<td><%=abitanteItem.getCognome() %></td>
					<td><a href="VisualizzaDettaglioServlet?idDaInviareComeParametro=<%=abitanteItem.getIdAbitante() %>">Dettaglio</a></td>
				</tr>
		<%	}%>
	<br><br>	
	<button type="button" onclick="location.href='PrepareInsertAbitanteServlet'"style=padding:10px>Inserisci</button>
	<br><br>
	</table>
</body>
</html>