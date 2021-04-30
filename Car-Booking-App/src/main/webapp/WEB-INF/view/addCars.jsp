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

<title>Add Vehicle</title>
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
</head>
<body>
		<div style="padding-top:1%">
			<div class="row">
				<div class="col">
					<h3 style="padding-left:30%">Enter Vehicle Details</h3>
				</div>
				<div class="col	">
					<button type="button" class="btn btn-primary" ><a href="${pageContext.request.contextPath}/car" style="color:white">Back</a></button>
				</div>
			</div>
			</div>
			<div style="padding-top:2%">
				<div class="container">
  					<form:form action="saveCars" modelAttribute="car" method="POST">
  							<form:hidden path="id" />
  							here the id is ${car.id}
  							<br>
						    <label for="fname">uniqeId</label>
						    <form:input type="text" path="uniqueId" name="firstname" placeholder="UniqueId"/>
    
						    <label for="lname">Model</label>
						    <form:input type="text" path="model" name="model" placeholder="Model"/>
	
						    <label for="lname">Brand</label>
						    <form:input type="text" path="brand" name="brand" placeholder="Brand"/>
							
							<label for="lname">Vehicle Number</label>
						    <form:input type="text" path="number" name="number" placeholder="Number"/>
							
							<label for="lname">Purchase Date</label>
						    <form:input type="text" path="purchaseDate" name="purchaseDate" placeholder="Purchase Date"/>
							
							
							<label for="color">Color</label>
						    <form:input type="text" path="color" name="color" placeholder="Color"/>
						    
						    <label for="price">Price</label>
						    <form:input type="text" path="price" name="price" placeholder="price"/>
							
						    <label for="fuelType">Fuel Type</label>
						    <form:select path="fuelType" name="fuelType">
						      <option value="Petrol">Petrol</option>
						      <option value="diesel">Diesel</option>
						    </form:select>
						    
							
						    <label for="Type">Vehicle Type</label>
						    <form:select path="type" name="Type">
						      <option value="Car">Car</option>
						      <option value="Van">Van</option>
						    </form:select>
						    
						    
						    <label for="availability">Availability</label>
						    <form:select path="availability" name="availability">
						      <option value="1">true</option>
						      <option value="0">false</option>
						    </form:select>
						
						
						   
						    <input type="submit" value="Add Vehicle" />
  					</form:form>
				</div>
			</div>
</body>
</html>