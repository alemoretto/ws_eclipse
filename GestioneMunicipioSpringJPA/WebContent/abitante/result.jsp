<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	List<Abitante> listaAbitanti = (List<Abitante>)request.getAttribute("listaAbitantiAttributeName"); %>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>La ricerca ha prodotto <%= listaAbitanti.size() %> risultati: </h3>
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
			for(Abitante abitanteItem:listaAbitanti){
		%>
			<tr>
				<td><%=abitanteItem.getNome() %></td>
				<td><%=abitanteItem.getCognome() %></td>
				<td>
					<a href="VisualizzaDettaglioAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PreparaModificaAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PreparaEliminaAbitanteServlet?idAbitante=<%=abitanteItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>

</body>
</html>



