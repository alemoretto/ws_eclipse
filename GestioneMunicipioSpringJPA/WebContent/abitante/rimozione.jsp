<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Abitante</title>
</head>
<body>

	<%
	Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteSingoloAttributeName");
	%>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio di <%=abitanteInPagina.getNome()%> <%=abitanteInPagina.getCognome()%></h3>
		</div>
		
<!-- 		<table class="table table-striped"> -->
<!-- 		<thead> -->
<!-- 		<th> -->
<div class="col-sm-3">
		<div class="container-fluid">
		<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cognome</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getCognome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Et�</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getEta()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Residenza</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getResidenza()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Municipio</dt>
				<dd class="col-sm-9"><%=abitanteInPagina.getMunicipio().getDescrizione()%></dd>
			</dl>
		</div>
		</div>
<a href="ExecuteEliminaAbitanteServlet?idAbitante=<%=abitanteInPagina.getId()%>" class="btn btn-primary btn-md">Conferma rimozione</a></div>

</body>
</html>