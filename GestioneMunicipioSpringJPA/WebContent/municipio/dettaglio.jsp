<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
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
		Municipio municipioInPagina = (Municipio) request.getAttribute("municipioSingoloAttributeName");
	%>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio del <%=municipioInPagina.getDescrizione()%></h3>
		</div>
		
<!-- 		<table class="table table-striped"> -->
<!-- 		<thead> -->
<!-- 		<th> -->
<div class="col-sm-3">
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getDescrizione()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Uva</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getCodice()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Annata</dt>
				<dd class="col-sm-9"><%=municipioInPagina.getUbicazione()%></dd>
			</dl>
		</div>
		</div>
		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-primary btn-md">Nuova ricerca</a>
</div>

</body>
</html>