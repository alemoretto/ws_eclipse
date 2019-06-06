<%@page import="it.prova.model.Vino"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Vino</title>
</head>
<body>

	<%
		Vino vinoInPagina = (Vino) request.getAttribute("vinoSingoloAttributeName");
	%>

	<div class="container">

		<%@ include file="header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio</h3>
		</div>
		
<!-- 		<table class="table table-striped"> -->
<!-- 		<thead> -->
<!-- 		<th> -->
<div class="col-sm-3">
		<div class="container-fluid">
			<dl class="row">
				<dt class="col-sm-3 text-right">Id</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getId()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Nome</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getNome()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Uva</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getUva()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Annata</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getAnnata()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Cantina</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getCantina()%></dd>
			</dl>
			<dl class="row">
				<dt class="col-sm-3 text-right">Località</dt>
				<dd class="col-sm-9"><%=vinoInPagina.getLocalita()%></dd>
			</dl>
		</div>
		</div>
<!-- 			</th> -->
<!-- <th> -->
<div class="col-sm-3">
		<img src="images/pirrovarone.jpg" alt="pirrovarone" width="144" height="350" class="float-left"></div>
		</div>
<!-- 	</th>	 -->
<!-- </thead> -->
<!-- </table> -->
	</div>

</body>
</html>