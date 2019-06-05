<%@page import="it.prova.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione completata</title>
</head>
<body>
<% Persona localAttribute = (Persona) request.getAttribute("persona_attribute"); %>

Nome: <%= localAttribute.getNome() %> <br>
Cognome: <%= localAttribute.getCognome() %>
<br><br>
<button type="button" onclick="location.href='registra.jsp'"style=padding:10px>Torna indietro</button>



</body>
</html>