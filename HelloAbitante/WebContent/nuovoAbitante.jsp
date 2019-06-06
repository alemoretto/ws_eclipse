<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<h3 style="color:red"><%=request.getAttribute("messaggioDiErrore") %> </h3><br>
	<% }else{ %>
		<h3>Inserire i dati del nuovo abitante</h3><br>
	<%} %>
	
<form action="ExecuteInsertAbitanteServlet" method="post" id="nuovoAbitanteForm">
<fieldset style="width:300px"><legend><strong>Dati personali:</strong></legend>
	Nome:<br>
	<input type="text" name="nomeInput" style="width:200px" required >
	<br>
	Cognome:<br>
	<input type="text" name="cognomeInput" style="width:200px" required>
		<br>
	Codice Fiscale:<br>
	<input type="text" name="codiceFiscaleInput" style="width:200px" required>
		<br>
	Età:<br>
	<input type="number" name="etaInput" min="1" max="99" style="width:200px" required>
		<br>
	Motto di vita:<br>
	<textarea rows="4" cols="50" name="comment" form="nuovoAbitanteForm"></textarea>
<!-- 	<input type="textarea" name="mottoDiVitaInput" > -->
	<br><br>	
	<input type="submit" value="Registra" style="margin-left: 10px;width:180px;padding:5px;float:right;display: block;">
<!-- 	<button type="button" onclick="location.href='javascript:history.back()'" style="width:120px;padding:5px;float:left">Torna</button> -->
	<button type="button" onclick="location.href='SearchServlet'" style="margin-left: 5px; width:100px;padding:5px;float:left; display: block;">Torna</button>

	</fieldset>
	</form>
	
</body>
</html>