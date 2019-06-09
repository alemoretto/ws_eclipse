<%@page import="java.util.List"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento Cartella Esattoriale</title>
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
<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Nuova Cartella Esattoriale</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteInserisciCartellaEsattorialeServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId" name="importoInput" >
			 	</div>
  			</div>

			<%
				List<Contribuente> listaContribuenti = (List<Contribuente>) request
						.getAttribute("listaContribuentiAttributeName");
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
						<option value="<%=contribuenteItem.getId()%>">
							<%=contribuenteItem.getNome()%>
							<%=contribuenteItem.getCognome()%> -
							<%=contribuenteItem.getCodiceFiscale()%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>


			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Inserisci nuova Cartella Esattoriale</button>
		      </div>
		    </div>
		    
		</form>
		
    </div><!-- /.container -->



</body>
</html>