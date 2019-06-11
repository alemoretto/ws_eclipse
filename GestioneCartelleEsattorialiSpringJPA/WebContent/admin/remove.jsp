<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dettaglio Cartella Esattoriale</title>
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina di Dettaglio dell'Utente:  ${utenteDTOAttribute.username}</h3>
		</div>
		<br>
		<div class="container-fluid" id="idContainer">
		
		<c:forEach items="${utenteDTOAttribute.fieldsNames()}" var="field">
			<dl class="row">
				<dt class="col-sm-3 text-right">${field.key }</dt>
				<dd class="col-sm-9"> ${utenteDTOAttribute.fieldsValues[field.key]}</dd>
			</dl>
		</c:forEach>
		
		<dl class="row">
			<dt class="col-sm-3 text-right">Ruolo</dt>
			<dd class="col-sm-9">
			<c:forEach items="${ruoliUtenteDTOAttribute}" var="ruolo" varStatus="loop">
				${ruolo.descrizione} 
				<c:if test="${ruoliUtenteDTOAttribute.size()-1 > loop.index}">, </c:if>  
			</c:forEach>
			</dd>
		</dl>
		<a href="ExecuteEliminaUtenteServlet?idUtente=${utenteDTOAttribute.id}" class="btn btn-primary btn-md" >Rimuovi</a>
		</div>
		</div>


</body>
</html>
