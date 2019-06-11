<%@page import="java.util.List"%>
<%@page
	import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Utente</title>
</head>
<body onload="check()">

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Modifica Utente</h3>
		</div>

		<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/ExecuteModificaUtenteServlet" method="post">
			<input type="hidden" name="idInput" value="${utenteDTOAttribute.id}">

			<%@ include file="./inputForm.jsp"%>

			<c:forEach items="${listRuoliAttribute}" var="ruoloItemLista">
				<div class="custom-control custom-checkbox">
					<input id="${ruoloItemLista.id}" type="checkbox" name="ruoloItem" value="${ruoloItemLista.id}" class="custom-control-input" 
					<c:forEach items="${utenteDTOAttribute.iDruoli}" var="ruolo">
				   		<c:if test="ruolo == ruoloItemLista">checked="checked"</c:if>
					</c:forEach>> 
					<label class="custom-control-label" for="${ruoloItemLista.id}">${ruoloItemLista.descrizione}</label><br>
				</div>
			</c:forEach>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Aggiorna</button>
				</div>
			</div>
		</form>


	</div>
	<!-- /.container -->

</body>
</html>