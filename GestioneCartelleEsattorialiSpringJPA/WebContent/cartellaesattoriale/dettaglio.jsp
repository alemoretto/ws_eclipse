<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Cartella Esattoriale</title>
</head>
<body>

	<%
		CartellaEsattoriale cartellaEsattorialeInPagina = (CartellaEsattoriale) request.getAttribute("cartellaEsattorialeAttributeName");
	%>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio della Cartella:  <%=cartellaEsattorialeInPagina.getDenominazione()%></h3>
		</div>
		
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=cartellaEsattorialeInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Denominazione</dt>
				<dd class="col-sm-9"><%=cartellaEsattorialeInPagina.getDenominazione()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Descrizione</dt>
				<dd class="col-sm-9"><%=cartellaEsattorialeInPagina.getDescrizione()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Importo</dt>
				<dd class="col-sm-9"><%=cartellaEsattorialeInPagina.getImporto()%>  euro</dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Contribuente</dt>
				<dd class="col-sm-9"><%=cartellaEsattorialeInPagina.getContribuente().toString()%></dd>
			</dl>
		</div>
		</div>
<%-- 		<a href="<%= request.getContextPath()%>/home.jsp" class="btn btn-primary btn-md" >Nuova ricerca</a> --%>

</body>
</html>