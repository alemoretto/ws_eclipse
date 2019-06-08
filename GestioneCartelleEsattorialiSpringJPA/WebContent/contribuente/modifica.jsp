<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Municipio</title>
</head>
<body>
	<%
		if (request.getAttribute("messaggioDiErrore") != null) {
	%>
	<h3 style="color: red"><%=request.getAttribute("messaggioDiErrore")%>
	</h3>
	<br>
	<%
		}
	%>
	<%
		Contribuente contribuenteInPagina = (Contribuente) request.getAttribute("contribuenteDaModificareAttributeName");
	%>
	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Modifica il Contribuente</h3>
		</div>

		<form class="form-horizontal"
			action="ExecuteModificaContribuenteServlet" method="post">
			<input type="hidden" name="idInput" value="<%=contribuenteInPagina.getId() %>">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="<%=contribuenteInPagina.getNome() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="<%=contribuenteInPagina.getCognome() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceFiscaleInputId">Codice
					Fiscale:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceFiscaleInputId"
						name="codiceFiscaleInput" value="<%=contribuenteInPagina.getCodiceFiscale() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId"
						name="indirizzoInput" value="<%=contribuenteInPagina.getIndirizzo() %>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Salva le modifiche</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>
</html>