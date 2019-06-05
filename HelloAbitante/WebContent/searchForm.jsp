<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca abitante</title>
</head>
<body>
	<%if(request.getAttribute("messaggioDiErrore") != null){ %>
		<%=request.getAttribute("messaggioDiErrore") %>
	<% }else{ %>
		Inserire dati da ricercare<br>
	<%} %>
	<form action="SearchServlet" method="post">
	NOME:
	<input type="text" name="nomeInput" >
	<br>
	COGNOME:
	<input type="text" name="cognomeInput" >
	
	<input type="submit" value="CERCA">
	
	</form>

</body>
</html>