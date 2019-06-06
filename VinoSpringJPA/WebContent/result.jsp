<%@page import="it.prova.model.Vino"%>
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
				<th>Uva</th>
				<th>Action</th>
			</tr>
		</thead>
		<%
			List<Vino> listaVini = (List<Vino>)request.getAttribute("listaViniAttributeName"); 
			for(Vino vinoItem:listaVini){
		%>
			<tr>
				<td><%=vinoItem.getNome() %></td>
				<td><%=vinoItem.getUva() %></td>
				<td>
					<a href="VisualizzaDettaglioVinoServlet?idVino=<%=vinoItem.getId() %>" class="btn btn-info">Dettaglio</a>
					<a href="PreparaModificaVinoServlet?idVino=<%=vinoItem.getId() %>" class="btn btn-info">Modifica</a>
					<a href="PreparaEliminaVinoServlet?idVino=<%=vinoItem.getId() %>" class="btn btn-info">Elimina</a>
				</td>
			</tr>
				
		<%	}
		
		%>
	
	</table>
	<a href="PreparaInsertVinoServlet" class="btn btn-info">Inserisci Nuovo Elemento</a>

	</div>
</body>
</html>