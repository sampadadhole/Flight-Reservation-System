<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Booked Tickets</title>
</head>
<body>
<table border="1">
            <tr>
            	
               <!--  <th>Flight Name</th> -->
               
                <th>Ticket ID</th>
                <th>Flight Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>User</th>
              <!--   <th>Destination arrival time</th>
                <th>Available Seats</th> -->
            </tr>
			<c:forEach var="flight" items="${sessionScope.Allticketslist}">
           
               <td>${flight.ticketID}</td> 
         		<td>${flight.getFlightlist().flightName}</td> 
         		<td>${flight.getTravellers().firstName}</td> 
         		<td>${flight.getTravellers().lastName}</td> 
         		<td>${flight.getTravellers().airlineUsername}</td>
     
                </tr>   
         </c:forEach>
        </table>
</body>
</html>