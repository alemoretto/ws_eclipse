<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Ricerca abitante</title>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<link rel="stylesheet" type="text/css" href="myCSS.css">

</head>
<body>
	<div class="container">
		<h2>Cerca un abitante:</h2>
		<form action="SearchServlet" method="post">
			<fieldset style="width: 300px">
				<legend></legend>
				Nome: <br> <input type="text" name="nomeInput"
					style="width: 250px"> <br> Cognome: <br> <input
					type="text" name="cognomeInput" style="width: 250px"> <br>
				<br> <input type="submit" value="Cerca"
					style="width: 240px; padding: 10px; align: center">
		</form>
	</div>
</body>
</html>