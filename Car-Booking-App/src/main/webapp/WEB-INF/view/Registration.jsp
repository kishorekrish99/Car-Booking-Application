     <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

<title>Book Vehicle</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;

}
</style>
<script>
function myFunction() {
	const params = new URLSearchParams(window.location.search)
	const p=0;
	for (const param of params) {
	  console.log(param[1]);
	  document.getElementById("kk").value=param[1];
	  return param[1];
	}
}
</script>
</head>
<body  onload="myFunction()">



		<div style="padding-top:1%">
			<div class="row">
				<div class="col">
			<h2 class="mb-4"  align="center"><u>Book A Vehicle</u></h2>
		
				</div>
				<div class="col">
				<div style="padding-left:50%;">
					<button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/car" style="color:white">Back</a></button>
				</div>
				</div>
			</div>
			</div>

		<div style="padding-top:2%">
<div class="container">
  <form:form action="bookthecar" modelAttribute="rental" method="POST">
  	
  	 <label for="carid">car id</label>
	<form:input type="text" path="carid" id="kk" name="carid" />
	
	
    <label for="customer">customer</label>
    <form:input type="text" path="username"  name="customer" value="${credentails.username}" />
    
    <label for="pickupdate">PickUp Date</label>
    <form:input type="text" path="pickupdate" name="pickupdate" placeholder="DD-MMM-YYYY"/>
	
    <label for="pickuptime">Pick-up Time</label>
    <form:input type="text" path="pickuptime" name="pickuptime" placeholder="HH:MM"/>
	
	<label for="returndate">Return Date</label>
    <form:input type="text" path="returndate" name="returndate" placeholder="DD-MMM-YYYY"/>
	
	<label for="returntime">Return Time</label>
    <form:input type="text" path="returntime" name="returntime" placeholder="HH:MM"/>
	
	
	<label for="pickuplocation">PickUp Location</label>
    <form:select path="pickuplocation" name="pickuplocation">
      <option value="location 1">Location 1</option>
      <option value="location 2">Location 2</option>
      <option value="location 3">Location 3</option>
      <option value="location 4">Location 4</option>
    </form:select>
	
	
    <label for="returnlocation">Return Location</label>
    <form:select path="returnlocation" name="returnlocation">
      <option value="location 1">Location 1</option>
      <option value="location 2">Location 2</option>
      <option value="location 3">Location 3</option>
      <option value="location 4">Location 4</option>
    </form:select>
    
   	
   	<label for="discount">Discount (as per age)</label>
   	
   	<c:set var = "age" scope = "session" value = "${credentails.age}"/>
   	<c:out value="${age}"></c:out>
     <c:choose>
  		<c:when test="${age < 25}">
   			 <form:input type="text"  id="age" path="discount" name="discount" value="10" readonly="true" />
  		</c:when>
  		<c:otherwise>
    		<form:input type="text" path="discount"  id="age" name="discount" value="20"  readonly="true"/>
    		
  		</c:otherwise>
	</c:choose>
	

	   
    <input type="submit" value="Add Vehicle" onclick="${bookacar}"/>
  </form:form>
</div>
</div>






</body>