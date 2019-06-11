<%@page import="java.util.List"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Nuovo Utente</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Nuovo Utente</h3>
	</div>
	
	
<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/ExecuteInserisciUtenteServlet" method="post">
		<c:forEach items="${utenteDTOAttribute.fieldsNames()}" var="field" varStatus="loop" >
			<div class="form-group">
      			<label class="control-label col-sm-2" for="${field.value}Id">${field.key}:</label>
      			<c:if test="${messaggiDiErrore[field.value] != null}">
					<div class="alert alert-danger">
						${messaggiDiErrore[field.value]}</div>
				</c:if>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="${field.value}Id" name="${field.value}" value="${utenteDTOAttribute.fieldsValues[field.key]}"  >
			 	</div>
  			</div>
		</c:forEach>
		
		<c:forEach items="${listRuoliAttribute}" var="ruoloItemLista">
			<input type="checkbox" name="ruoloItem" value="${ruoloItemLista.id}"> ${ruoloItemLista.descrizione}<br>
		</c:forEach>
		
		<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Inserisci nuovo Utente</button>
		      </div>
		    </div>
		</form>

		
    </div><!-- /.container -->



</body>
</html>