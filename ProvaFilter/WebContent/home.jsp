<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%@ include file="header.jsp" %>

	<div class="alert alert-danger ${messaggio==null?'d-none':''}" role="alert">
	  ${messaggio }
	</div>

	<div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione per tutti</h1>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/AltraServlet" role="button">Vai ad Altra Servlet &raquo;</a></p>
      </div>
	</div>
	
	<div class="jumbotron">
      <div class="container">
        <h1 class="display-4">Gestione solo per admin</h1>
        <p><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/admin/AltraServletPerAdmin" role="button">Vai ad Altra Servlet Per Admins &raquo;</a></p>
      </div>
	</div>
</body>
</html>