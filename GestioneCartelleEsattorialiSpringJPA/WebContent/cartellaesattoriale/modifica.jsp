<%@page import="java.util.List"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Cartella Esattoriale</title>
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
		CartellaEsattoriale cartellaEsattorialeInPagina = (CartellaEsattoriale) request.getAttribute("cartellaEsattorialeDaModificareAttributeName");
	%>
<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Modifica Cartella Esattoriale</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteModificaCartellaEsattorialeServlet" method="post">
      	<input type="hidden" name="idInput" value="<%=cartellaEsattorialeInPagina.getId() %>">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" 
					name="denominazioneInput" value="<%=cartellaEsattorialeInPagina.getDenominazione() %>">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" 
					name="descrizioneInput" value="<%=cartellaEsattorialeInPagina.getDescrizione() %>">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId" 
					name="importoInput" value="<%=cartellaEsattorialeInPagina.getImporto() %>">
			 	</div>
  			</div>

			<%
				List<Contribuente> listaContribuenti = (List<Contribuente>) request.getAttribute("listaContribuentiAttributeName");
			%>
			<div class="form-group">
				<label class="control-label col-sm-6" for="contribuenteInputId">Contribuente:</label>
				<div class="col-sm-6">
					<select name="contribuenteInput" class="control-label col-sm-6"
						id="contribuenteInputId">
						<option value="-1">Seleziona un Contribuente</option>

						<%
							for (Contribuente contribuenteItem : listaContribuenti) {
						%>
						<option value="<%=contribuenteItem.getId()%>"
						<% if(contribuenteItem.getId() == cartellaEsattorialeInPagina.getContribuente().getId()){%> selected<%} %> >
							<%=contribuenteItem.toString()%> - <%=contribuenteItem.getCodiceFiscale()%></option>
						<%
							}
						%>
					</select>
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