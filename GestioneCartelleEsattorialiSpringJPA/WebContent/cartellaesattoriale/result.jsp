<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale"%>
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
<%	List<CartellaEsattoriale> listaCartelleEsattoriali = (List<CartellaEsattoriale>)request.getAttribute("listaCartelleEsattorialiAttributeName"); %>
<div class="container">

  	<%@ include file="../header.jsp" %>
  	
  	<div class="page-header">
	  <h3>La ricerca ha prodotto <%= listaCartelleEsattoriali.size() %> risultati: </h3>
	</div>
  	
<table class="table table-striped">
		<thead>
			<tr>
				<th>Denominazione</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
			for(CartellaEsattoriale cartellaItem:listaCartelleEsattoriali){
		%>
			<tr>
				<td><%=cartellaItem.getDenominazione() %></td>
				<td>
					<a href="VisualizzaDettaglioCartellaEsattorialeServlet?idCartellaEsattoriale=<%=cartellaItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PrepareModificaCartellaEsattorialeServlet?idCartellaEsattoriale=<%=cartellaItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PrepareEliminaCartellaEsattorialeServlet?idCartellaEsattoriale=<%=cartellaItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>

</body>
</html>



