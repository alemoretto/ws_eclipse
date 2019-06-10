<%@page import="java.util.List"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.Contribuente"%>
<%@page import="it.prova.gestionecartelleesattorialispringjpa.model.CartellaEsattoriale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Cartella Esattoriale</title>
</head>
<body>

<div class="container">

   <%@ include file="../header.jsp" %>
      
    <div class="page-header">
	  <h3>Modifica Cartella Esattoriale</h3>
	</div>

      	<form class="form-horizontal" action="ExecuteModificaCartellaEsattorialeServlet" method="post">
      	<input type="hidden" name="idInput" value="${cartellaEsattorialeDTOAttribute.id}">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="denominazioneInputId">Denominazione:</label>
      			<c:if test='${messaggiDiErrore.denominazioneInput != null}'>
					<div class="alert alert-danger">
						${messaggiDiErrore.denominazioneInput}</div>
				</c:if>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="denominazioneInputId" name="denominazioneInput" 
					value="${cartellaEsattorialeDTOAttribute.denominazione}">
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="descrizioneInputId">Descrizione:</label>
      			<c:if test='${messaggiDiErrore.descrizioneInput != null}'>
					<div class="alert alert-danger">
						${messaggiDiErrore.descrizioneInput}</div>
				</c:if>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="descrizioneInputId" name="descrizioneInput" 
					value="${cartellaEsattorialeDTOAttribute.descrizione}">
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="importoInputId">Importo:</label>
      			<c:if test='${messaggiDiErrore.importoInput != null}'>
					<div class="alert alert-danger">
						${messaggiDiErrore.importoInput}</div>
				</c:if>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="importoInputId" name="importoInput"
					value="${cartellaEsattorialeDTOAttribute.importo}" >
			 	</div>
  			</div>
  			
			<div class="form-group">
				<label class="control-label col-sm-6" for="contribuenteInputId">Contribuente:</label>
				<c:if test='${messaggiDiErrore.contribuenteInput != null}'>
					<div class="alert alert-danger">
						${messaggiDiErrore.contribuenteInput}</div>
				</c:if>
				<div class="col-sm-6">
					<select name="contribuenteInput" class="control-label col-sm-6"
						id="contribuenteInputId">
						<option value="-1">Seleziona un Contribuente</option>
						<c:forEach items="${listaContribuentiAttributeName}" var="contribuenteItem">
						<option value="${contribuenteItem.id}" <c:if test='${contribuenteItem.id == cartellaEsattorialeDTOAttribute.contribuente}'> selected</c:if> >
							${contribuenteItem.toString() } - ${contribuenteItem.codiceFiscale}
							</option>
						</c:forEach>
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