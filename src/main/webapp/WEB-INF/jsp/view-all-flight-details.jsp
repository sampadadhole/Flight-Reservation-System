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
<h1> View all flight details</h1>
<form action="./ViewAllFLightDetails.htm" method="get">

 <table border="1">
            <tr>
            	
               <th>Flight Number</th>
                <th>Flight Name</th>
                <th>Airplane Id</th>
                <th>Price</th>
                <th>Departure Place</th>
                <th>Depature Date</th>
                <th>Departure time</th>
                <th>Arrival Place</th>
                <th>Arrival Date</th>
                <th>Arrival time </th>
                <th>Available Seats</th>
                
            </tr>
   
			<c:forEach var="flight" items= "${sessionScope.fliList}">
			<%-- <c:set var="id" value="${schoolDetails.value}"/> --%>
                <tr>
                   	 <td>${flight.fliID}</td>
                    <td>${flight.flightName}</td>
                    <td>${flight.flightID}</td>
                    <td>$${flight.price}</td>
                    <td>${flight.fromplace}</td>
                    <td>${flight.departureDate}</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.toplace}</td>
                    <td>${flight.arrivalDate}</td>
                    <td>${flight.arrivalTime}</td>
                   <td>${flight.totalSeats}</td> 
         			<td> <input type="hidden" name="flightid" value="${flight.fliID}" /></td>
                    <td><a href="EditFlightDetails.htm?fli_id=${flight.fliID}"  id="link">Edit Flight</a></td>
       				<td><a href="delete-flight-details.htm?fli_id=${flight.fliID}"  id="link">Delete Flight</a></td>
                </tr>   
         </c:forEach>
        
        </table>
	
</form>
</body>
</html>