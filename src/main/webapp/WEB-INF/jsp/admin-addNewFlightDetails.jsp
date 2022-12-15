<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	h1{text-align:center;}
	form{text-align:center;}
	form{border: 0.2rem black solid;}
	form{margin:auto;}
	form{max-width:23rem;}
	form{padding: 1rem;}
	/* div{text-align:center;}
	div{margin:0.4rem;}
	input{text-align:center;} */
</style>
<body>
<h1>Add New Flight</h1>
<form action="./addNewFlight.htm" method="post" modelAttribute="flightDetails">
<table>

<tr>
<td>Flight ID</td>
<td><input type="text" name="flightID" required="required"/></td>
</tr> 

<tr>
<td>Flight Name</td>
<td><input type="text" name="flightName" required="required"/></td>
</tr>

<!-- <tr>
<td>Flight Company</td>
<td><input type="text" name="flightCompany" required="required"/></td>
</tr> -->

<tr>
<td>From Place:</td>
<td><input type="text" name="fromplace" required="required"/></td>
</tr>

<tr>
<td>To Place:</td>
<td><input type="text" name="toplace" required="required"/></td>
</tr>

<tr>
<td>Departure Time:</td>
<td><input type="text" name="departureTime" required="required"/></td>
</tr>

<tr>
<td>Arrival Time:</td>
<td><input type="text" name="arrivalTime" required="required"/></td>
</tr>

<tr>
<td>Departure Date:</td>
<td><input type="date" name="departureDate" required="required"/></td>
</tr>

<tr>
<td>Arrival Date:</td>
<td><input type="date" name="arrivalDate" required="required"/></td>
</tr>

<tr>
<td>Travel class:</td>
<td><input type="text" name="travleClass" required="required"/></td>
</tr>

<tr>
<td>Total Seats:</td>
<td><input type="text" name="totalSeats" required="required"/></td>
</tr>

<tr>
<td>No of seats available:</td>
<td><input type="text" name="NoSeatsAvaialable" required="required"/></td>
</tr>

<tr>
<td>Price:</td>
<td><input type="text" name="price" required="required"/></td>
</tr>

<td><input type="submit" value="Add Flight" /></td>

</table>
</form>
</body>
</html>