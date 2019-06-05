<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%	
Abitante abitanteDettagliato = (Abitante)request.getAttribute("abitanteDaInviareAPaginaDettalio");
%>
<h3><strong>Informazioni su:</strong></h3> 
<h4><%= abitanteDettagliato.getNome() %> <%= abitanteDettagliato.getCognome() %></h4><br>

Nome:   <%= abitanteDettagliato.getNome() %><br>
Cognome:   <%= abitanteDettagliato.getCognome() %><br>
CodiceFiscale:   <%= abitanteDettagliato.getCodiceFiscale() %><br>
Eta:   <%= abitanteDettagliato.getEta() %><br>
Motto di vita:   <%= abitanteDettagliato.getMottoDiVita() %><br>


</body>
</html>