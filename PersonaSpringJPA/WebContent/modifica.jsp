<%@page import="it.prova.utility.Utility"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
</head>
<body>
<%
	if(request.getAttribute("messaggioDiErrore") != null){
%>
		<h3 style="color:red"><%=request.getAttribute("messaggioDiErrore")%> </h3><br>
	<%
		}
	%>
<%
	Persona personaInPagina = (Persona) request.getAttribute("personaDaModificareAttributeName");
%>
	<div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteModificaPersonaServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId" >Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%= personaInPagina.getNome()%>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId" name="cognomeInput" value="<%= personaInPagina.getCognome()%>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId" name="etaInput" value="<%= personaInPagina.getEta()%>" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cfInputId">CF:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cfInputId" name="cfInput" value="<%= personaInPagina.getCf()%>" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="indirizzoInputId">Indirizzo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="indirizzoInputId" name="indirizzoInput" value="<%= personaInPagina.getIndirizzo()%>" >
					<input class="form-control" type="hidden" id="idInputId" name="idInput" value="<%= personaInPagina.getId()%>" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Aggiorna</button>
		      </div>
		    </div>
		</form>

    </div><!-- /.container -->

	

</body>
</html>