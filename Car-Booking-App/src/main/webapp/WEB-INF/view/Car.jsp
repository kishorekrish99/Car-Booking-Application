<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
<head>
<title>
Car Rental
</title>
 <link rel = "icon" href ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZzsRJn1M865Zfto6riI_hIFfdOnkwsmvcpQ&usqp=CAU" 
        type = "image/x-icon"> 
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/css/style.css">

</head>
<body>

	<div class="wrapper d-flex align-items-stretch">
		<nav id="sidebar">
			<h1>
				<a href="#" class="logo">CAR RENTAL</a>
			</h1>
			<ul class="list-unstyled components mb-5">
				<li class="active"><a href="${pageContext.request.contextPath}/"><span
						class="fa fa-home mr-3"></span> Homepage</a></li>
				<li class="active"><a href="${pageContext.request.contextPath}/car"><span
						class="fa fa-car mr-3"></span> Car</a></li>
				<security:authorize access="hasRole('ROLE_ADMIN')">  
				<li class="active"><a href="${pageContext.request.contextPath}/users"><span
						class="fa fa-user mr-3"></span> Users</a></li>
				</security:authorize>
				 <security:authorize access="hasAnyRole('ROLE_CUSTOMER')">  
				<li class="active"><a href="${pageContext.request.contextPath}/usertransaction"><span
						class="fa fa-book mr-3"></span>Tranactions</a></li>
				</security:authorize>
				<security:authorize access="hasAnyRole('ROLE_CUSTOMER')">  
				<li class="active"><a href="${pageContext.request.contextPath}/currenttransaction"><span
						class="fa fa-file-text mr-3"></span>CurrentTranactions</a></li>
				</security:authorize>
				
				
				<form:form action="${pageContext.request.contextPath}/logout"
					method="POST">
					<li>
					<div style="padding-top:0px;" >
					<input type="submit" value="logout" style="padding-left:70px;padding-right:125px;background-color:black;color:white;height:50px;"></div>
					</li>
				</form:form>
			</ul>

		</nav>

	<!-- Page Content  -->
		<div id="content" class="p-4 p-md-5 pt-5">
				<h2 class="mb-4"  align="center"><u>Vehicles</u></h2>
		
			
		<div class="container">
			<div class="row">
				<div class="col">
					User: <security:authentication property="principal.username" />
					<br>
					Role(s): <security:authentication property="principal.authorities" />
				</div>
				<div class="col-xs-5">
					<security:authorize access="hasRole('ROLE_ADMIN')">  
					<button type="button" class="btn btn-primary" onclick="window.location.href='showFormforAdd';return false;">Add Vehicles</button>
					</security:authorize>
				</div>
			</div>
		</div>
			
			<section>
				<div style="padding-top: 30px;">
				<table id="example"
					class="table table-striped table-bordered dt-responsive nowrap"
					style="width: 100%">
					<thead>
						<tr>
							<th>Unique No.</th>
							<th>Brand</th>
							<th>Model</th>
							<th>Number</th>
							<th>Fuel Type</th>
							<th>Purchase Date</th>
							<th>Type</th>
							<th>Availability</th>
							<th>Color</th>
							<th>Price</th>
							<security:authorize access="hasRole('ROLE_ADMIN')">  
							<th>Edit</th>
							<th>Action</th>
							</security:authorize>
							<security:authorize access="hasRole('ROLE_CUSTOMER')">  
							<th>Action</th>
							</security:authorize>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempvehicle" items="${vehicle}">
							
							<c:url var="updateLink" value="showFormForUpdate">
								<c:param name="id" value="${tempvehicle.id}" />
							
							</c:url>
							
							<c:url var="deleteLink" value="delete">
								<c:param name="id" value="${tempvehicle.id}" />
							
							</c:url>
					
							<c:url var="bookacar" value="book">
								<c:param name="id" value="${tempvehicle.id}" />
							
							</c:url>
					
							<tr>
								<td>${tempvehicle.uniqueId}</td>
								<td>${tempvehicle.brand}</td>
								<td>${tempvehicle.model}</td>
								<td>${tempvehicle.number}</td>
								<td>${tempvehicle.fuelType}</td>
								<td>${tempvehicle.purchaseDate}</td>
								<td>${tempvehicle.type}</td>
								<td>${tempvehicle.availability}</td>
								<td>${tempvehicle.color}</td>
								<td>${tempvehicle.price}</td>
								<security:authorize access="hasRole('ROLE_ADMIN')">  
								<td><a href="${updateLink}">Update</a></td>
								</security:authorize>
								<security:authorize access="hasRole('ROLE_ADMIN')">  
								<td><a href="${deleteLink}" onclick="if (!(confirm('Are you sure to delete this Vehicle?'))) return false;">Remove</a></td>
								</security:authorize>
								<security:authorize access="hasRole('ROLE_CUSTOMER')">
								
									<c:set var = "available" scope = "session" value = "${tempvehicle.availability}"/>
     									<c:choose>
  											<c:when test="${available == true}">
   			 									<td><a href="${bookacar}">Book</a></td>
  											</c:when>
  											<c:otherwise>
    											<td>Not Available</td>
  											</c:otherwise>
										</c:choose>
								</security:authorize>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>
			
				
			
			</section>
		
		
		
		</div>
	</div>
	
	<script
		src="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/js/jquery.min.js"></script>
	<script
		src="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/js/popper.js"></script>
	<script
		src="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/js/bootstrap.min.js"></script>
	<script
		src="https://colorlib.com/etc/bootstrap-sidebar/sidebar-04/js/main.js"></script>
</body>
</html>