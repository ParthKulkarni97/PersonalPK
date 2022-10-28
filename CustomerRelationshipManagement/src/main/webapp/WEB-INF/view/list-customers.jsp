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
	
	<title>List Customers</title>
	
</head>

<body>
 	
 		
	<h1 style="text-align:center;background-color:green;font-size:300%" >Customer Relationship Management</h1>
		<hr>

		<!-- Add a search form -->
		<!-- Add a button -->
			<a href="/CustomerRelationshipManagement/customer/showFormForAdd"
				class="btn btn-primary btn-sm mb-3">Add Customer</a> 
			
		
		
			<table class="table table-bordered table-striped">
				<thead style="background-color:green;color:white">
				<tr >
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Address</th>
					<th>Action</th>
					
				</tr>
				</thead>
				<!-- print customers using loop -->
				<c:forEach var="tempCustomer" items="${customers}">
				
						
					<!-- generate an update link with customer id  -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="id" value="${tempCustomer.id}" />
					</c:url>	
					
					<!-- generate a delete link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="id" value="${tempCustomer.id}" />
					</c:url>		
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<!-- added javascript to prompt the user -->
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
			</table>
				
		</div>
	</div>
	
	
</body>

</html>
