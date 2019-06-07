<%@page import="it.prova.gestionemunicipiospringjpa.model.Abitante"%>
<%@page import="java.util.List"%>
<%@page import="it.prova.gestionemunicipiospringjpa.model.Municipio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Abitante</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("../img/anim_16x16.gif") right center no-repeat;
}
</style>
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
	Abitante abitanteInPagina = (Abitante) request.getAttribute("abitanteDaModificareAttributeName");
%>

	<div class="container">

		<%@ include file="../header.jsp"%>
		

		<div class="page-header">
			<h3>Pagina di Modifica Abitante</h3>
		</div>

		<form class="form-horizontal" action="ExecuteModificaAbitanteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
				<div class="col-sm-4">
				<input class="form-control" type="hidden" id="idInputId"
						name="idInput" value="<%=abitanteInPagina.getId() %>">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="<%=abitanteInPagina.getNome() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInputId">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="<%=abitanteInPagina.getCognome() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="etaInputId">Eta:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="etaInputId"
						name="etaInput" value="<%=abitanteInPagina.getEta() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="residenzaInputId">Residenza:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="residenzaInputId"
						name="residenzaInput" value="<%=abitanteInPagina.getResidenza() %>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-6" for="municipioInputId">Municipio:</label>
				<div class="col-sm-6">
				<select name="municipioInput"  class="control-label col-sm-6"  id="municipioInputId">
<!-- 				<option value="-1">Seleziona un Municipio</option> -->
<% List<Municipio> listaMunicipi = (List<Municipio>)request.getAttribute("listaMunicipiAttributeName"); 				
					for(Municipio municipioItem:listaMunicipi){	%>
    			<option value="<%= municipioItem.getId()%>" 
    			<% if(municipioItem.getId() == abitanteInPagina.getMunicipio().getId()){%> selected<%} %>> <%=municipioItem.getDescrizione()%></option>
    <%}%>
  </select>
<!-- 					<input class="form-control" type="text" id="municipioInputId" -->
<!-- 						name="municipioInput"> -->
				</div>
			</div>


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