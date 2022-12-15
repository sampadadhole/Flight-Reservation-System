<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String fli_id = (String) session.getAttribute("fli_id"); %>
<%session.getAttribute("fliList"); %>
<h1> Edit flight details for flight no: ${fli_id}</h1>

     
     <form action="./EditFlightDetails.htm" method="post" modelAttribute="Editflight">

	<c:forEach var="comp" items="${sessionScope.fliList}">
	<c:choose>
			<c:when test= "${comp.fliID !=fli_id}">
              
           </c:when>
           <c:otherwise>
           <div>
	<label>Flight Id</label>
	<input type="text" name="flight_id" value="${fli_id}" readonly />
	</div>
	</br>
	<div>
	<label>Flight Name</label>
	<input type="text" name="updatedflightName" value="${comp.flightName}"/>
	</div>
	
	</br>
	
	<div>
	<label>Departure Place</label>
	<input type="text" name="updatedfromplace" value="${comp.fromplace}" />
	</div>
	</br>
	
	<div>
	<label>Departure Date</label>
	<input type="text" name="updateddepartureDate" value="${comp.departureDate}"/>
	</div>
	</br>
	
		<div>
	<label>Departure time</label>
	<input type="text" name="updateddepartureTime" value="${comp.departureTime}"/>
	</div>
	</br>
		<div>
	<label>Arrival Place</label>
	<input type="text" name="updatedtoplace" value="${comp.toplace}"/>
	</div>
	</br>
		<div>
	<label>Arrival Date</label>
	<input type="text" name="updatedarrivalDate" value="${comp.arrivalDate}"/>
	</div>
	</br>
		<div>
	<label>Arrival time</label>
	<input type="text" name="updatedarrivalTime" value="${comp.arrivalTime}"/>
	</div>
	</br>
		<div>
	<label>Price</label>
	<input type="text" name="updatedprice" value="${comp.price}"/>
	</div>
	</br>
		<div>
	<label>Total Seats</label>
	<input type="text" name="updatedtotalSeats" value="${comp.totalSeats}"/>
	</div>
	</br>
			<div>
	<label>Travel Class</label>
	<input type="text" name="updatedtravelclass" value="${comp.travleClass}"/>
	</div>
	</br>

           
        </c:otherwise>
	</c:choose>
	</c:forEach>
	
	</br>
        <input type="submit" value="Update Flight details" />
     </form>
</body>

</html>