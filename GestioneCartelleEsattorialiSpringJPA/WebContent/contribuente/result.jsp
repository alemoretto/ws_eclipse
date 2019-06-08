<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	List<Contribuente> listaContribuenti = (List<Contribuente>)request.getAttribute("listaContribuentiAttributeName"); %>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>La ricerca ha prodotto <%= listaContribuenti.size() %> risultati: </h3>
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
			for(Contribuente contribuenteItem:listaContribuenti){
		%>
			<tr>
				<td><%=contribuenteItem.getNome() %></td>
				<td><%=contribuenteItem.getCognome() %></td>
				<td>
					<a href="VisualizzaDettaglioContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaContribuenteServlet?idContribuente=<%=contribuenteItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>

</body>
</html>



