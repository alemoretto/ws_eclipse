<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo Contribuente</title>
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Inserisci nuovo Contribuente</h3>
		</div>

		<form class="form-horizontal"
			action="ExecuteInserisciContribuenteServlet" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<c:if test='${messaggiDiErrore.nomeInput != null}'>
					<div class="alert alert-danger">
						${messaggiDiErrore.nomeInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="${contribuenteDTOAttribute.nome}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<c:if test='${messaggiDiErrore.cognomeInput != null }'>
					<div class="alert alert-danger">
						${messaggiDiErrore.cognomeInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="${contribuenteDTOAttribute.cognome}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="codiceFiscaleInputId">Codice
					Fiscale:</label>
				<c:if test='${messaggiDiErrore.codiceFiscaleInput != null }'>
					<div class="alert alert-danger">
						${messaggiDiErrore.codiceFiscaleInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceFiscaleInputId"
						name="codiceFiscaleInput" value="${contribuenteDTOAttribute.codiceFiscale}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
				<c:if test='${messaggiDiErrore.indirizzoInput != null}'>
					<div class="alert alert-danger">
						${messaggiDiErrore.indirizzoInput}</div>
				</c:if>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId"
						name="indirizzoInput" value="${contribuenteDTOAttribute.indirizzo}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Inserisci</button>
				</div>
			</div>
		</form>

	</div>
	<!-- /.container -->



</body>
</html>