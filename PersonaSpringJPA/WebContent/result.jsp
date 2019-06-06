<%@page import="it.prova.model.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>risultati</title>
</head>
<body>

	<div class="container">

  	<%@ include file="header.jsp" %>
  	
  	<div class="page-header">
	  <h3>Pagina dei Risultati</h3>
	</div>
  	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
			List<Persona> listaPersone = (List<Persona>)request.getAttribute("listaPersoneAttributeName"); 
			for(Persona personaItem:listaPersone){
		%>
			<tr>
				<td><%=personaItem.getNome() %></td>
				<td><%=personaItem.getCognome() %></td>
				<td>
					<a href="VisualizzaDettaglioPersonaServlet?idPersona=<%=personaItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PreparaModificaPersonaServlet?idPersona=<%=personaItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PreparaEliminaPersonaServlet?idPersona=<%=personaItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PreparaInsertPersonaServlet" class="btn btn-info">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>