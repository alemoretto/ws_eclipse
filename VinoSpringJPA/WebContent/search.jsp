<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
</head>
<body>

 <div class="container">

   <%@ include file="header.jsp" %>
      
    <div class="page-header">
	  <h3>Pagina di Ricerca</h3>
	</div>

      	<form class="form-horizontal" action="SearchVinoServlet" method="post">
      		<div class="form-group">
      			<label class="control-label col-sm-2" for="nomeInputId">Nome:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId" name="nomeInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="uvaInputId">Uva:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="uvaInputId" name="uvaInput" >
			 	</div>
  			</div>
  			<div class="form-group">
      			<label class="control-label col-sm-2" for="annataInputId">Annata:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="annataInputId" name="annataInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="cantinaInputId">Cantina:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="cantinaInputId" name="cantinaInput" >
			 	</div>
  			</div>
			<div class="form-group">
      			<label class="control-label col-sm-2" for="localitaInputId">Località:</label>
	    		<div class="col-sm-4">
					<input class="form-control" type="text" id="localitaInputId" name="localitaInput" >
			 	</div>
  			</div>
  			
  			<div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-primary btn-md">Cerca</button>
		      </div>
		    </div>
		</form>

    </div><!-- /.container -->

	

</body>
</html>