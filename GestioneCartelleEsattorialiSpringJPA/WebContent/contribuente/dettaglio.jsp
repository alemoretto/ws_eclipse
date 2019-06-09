<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Municipio</title>
</head>
<body>

	<%
		Contribuente contribuenteInPagina = (Contribuente) request.getAttribute("contribuenteAttributeName");
	%>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio di:  <%=contribuenteInPagina.toString()%> </h3>
		</div>
		
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Codice Fiscale</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getCodiceFiscale()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Indirizzo</dt>
				<dd class="col-sm-9"><%=contribuenteInPagina.getIndirizzo()%></dd>
			</dl>
		</div>
		</div>
<%-- 		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-primary btn-md" >Nuova ricerca</a> --%>

</body>
</html>