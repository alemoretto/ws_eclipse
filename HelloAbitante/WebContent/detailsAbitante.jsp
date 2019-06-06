<%@page import="it.helloabitante.model.Abitante"%>
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