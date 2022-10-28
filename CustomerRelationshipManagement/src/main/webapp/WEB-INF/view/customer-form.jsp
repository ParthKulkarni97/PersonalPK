<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!--  for spring forms tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

	<title>Add Customer</title>

	
</head>

<body>
	
	<div class="container">

		<h2 style="background-color:MediumSeaGreen;font-size:200%">Customer Directory</h2>
		<hr>

		<p class="h4 mb-4"><b>Save Customer</b></p>

		<form action="/CustomerRelationshipManagement/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${customers.id}" />

			<div class="form-inline">
				<input type="text" name="firstName" value="${customers.firstName}"
					class="form-control mb-4 col-4" placeholder="firstName">

			</div>

			<div class="form-inline">

				<input type="text" name="lastName" value="${customers.lastName}"
					class="form-control mb-4 col-4" placeholder="lastName">



			</div>

			
			<div class="form-inline">

				<input type="text" name="email" value="${customers.email}"
					class="form-control mb-4 col-4" placeholder="email">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>

		<hr>
		<a href="/CustomerRelationshipManagement/customer/list">Back to Customers List</a>

	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>

</html>
