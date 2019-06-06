<%@page import="it.prova.utility.Utility"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="it.prova.model.Vino"%>
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
	Vino vinoInPagina = (Vino) request.getAttribute("vinoDaModificareAttributeName");
%>
	<div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Modifica</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteModificaVinoServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId" >Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" value="<%= vinoInPagina.getNome()%>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="uvaInputId">Uva:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="uvaInputId" name="uvaInput" value="<%= vinoInPagina.getUva()%>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="annataInputId">Annata:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="annataInputId" name="annataInput" value="<%= vinoInPagina.getAnnata()%>" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cantinaInputId">Cantina:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cantinaInputId" name="cantinaInput" value="<%= vinoInPagina.getCantina()%>" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="localitaInputId">Localita:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="localitaInputId" name="localitaInput" value="<%= vinoInPagina.getLocalita()%>" >
					<input class="form-control" type="hidden" id="idInputId" name="idInput" value="<%= vinoInPagina.getId()%>" >
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