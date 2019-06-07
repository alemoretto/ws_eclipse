<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Municipio</title>
</head>
<body>

	<%
	if(request.getAttribute("messaggioDiErrore") != null){
%>
	<h3 style="color: red"><%=request.getAttribute("messaggioDiErrore")%>
	</h3>
	<br>
	<%
		}
	%>
	<%
	Municipio municipioInPagina = (Municipio) request.getAttribute("municipioDaModificareAttributeName");
%>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Modifica Municipio</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteModificaMunicipioServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput"
					value="<%= municipioInPagina.getDescrizione()%>" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="codiceInputId">Codice:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="codiceInputId" name="codiceInput" 
					value="<%= municipioInPagina.getCodice()%>" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="ubicazioneInputId">Ubicazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="ubicazioneInputId" name="ubicazioneInput" 
					value="<%= municipioInPagina.getUbicazione()%>" >
					<input class="form-control" type="hidden" id="idInputId" name="idInput" 
					value="<%= municipioInPagina.getId()%>" >
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