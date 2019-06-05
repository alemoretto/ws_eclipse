<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Buongiorno 
<% String localAttribute = (String) request.getAttribute("tuonome_attribute"); 
out.print(localAttribute);
%>
</body>
</html>