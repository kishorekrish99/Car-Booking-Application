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

VMedico
</title>
 <link rel = "icon" href ="https://www.clipartkey.com/mpngs/m/7-77917_hospital-icon-clipart-png-download-hospital-icon.png" 
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
			<div class="row">
				<div class="col">
			<h2 class="mb-4"  align="center"><u>DashBoard</u></h2>
		
			
			User: <security:authentication property="principal.username" />
			<br>
			Age: ${credentails.age}
			<br>
			Role(s): <security:authentication property="principal.authorities" />
				</div>
				
				</div>
			</div>
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