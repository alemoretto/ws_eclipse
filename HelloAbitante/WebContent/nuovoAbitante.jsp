<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ExecuteInsertAbitanteServlet" method="post">
	NOME:
	<input type="text" name="nomeInput" >
	<br>
	COGNOME:
	<input type="text" name="cognomeInput" >
		<br>
	CODICE FISCALE:
	<input type="text" name="codiceFiscaleInput" >
		<br>
	ETA':
	<input type="text" name="etaInput" >
		<br>
	MOTTO:
	<input type="text" name="mottoDiVitaInput" >
	
	
	<input type="submit" value="Registra">
	</form>
</body>
</html>