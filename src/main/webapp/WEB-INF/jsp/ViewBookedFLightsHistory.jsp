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
<h1>Booked Flights history for ${sessionScope.Username}</h1>
<% String Username = (String) session.getAttribute("Username"); 

%>
<form method="post" name="contact-form" action="./account/ViewBookedFLightsHistory.htm" modelAttribute="airlineUsers">

<table border="1">
            <tr>
            	
               <!--  <th>Flight Name</th> -->
               
                <th>Ticket ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                 <th>Flight Name</th>
                 <th>From Place</th>
                 <th>To Place</th>
                 <th>Departure Date</th>
                 <th>Departure Time</th>
                 <th>Arrival Date</th>
                 <th>Arrival Time</th>
         
            </tr>
			<c:forEach var="flight" items="${sessionScope.ticketslist}">
           <c:choose>
           <c:when test= "${flight.getTravellers().airlineUsername !=Username}">
             <%--  <td>${flight.getTravellers().airlineUsername}</td> --%>
             
           </c:when>
           <c:otherwise>
               <td>${flight.ticketID}</td>  
         		<td>${flight.getTravellers().firstName}</td> 
         		<td>${flight.getTravellers().lastName}</td> 
         		<td>${flight.getFlightlist().flightName}</td>
         		<td>${flight.getFlightlist().fromplace}</td>
         		<td>${flight.getFlightlist().toplace}</td>
         		<td>${flight.getFlightlist().departureDate}</td>
         		<td>${flight.getFlightlist().departureTime}</td>
         		<td>${flight.getFlightlist().arrivalDate}</td>
         		<td>${flight.getFlightlist().arrivalTime}</td>
     			<td><a id="foo" href="http://localhost:8081/airline/CancelBooking.htm?tid=${flight.ticketID}"  id="link">Cancel Ticket</a></td>
     			
                </tr>  
                </c:otherwise>
			</c:choose> 
         </c:forEach>
        </table>



<%-- <table border="1">
            <tr>
            	<th>Flight Number</th>
                <th>Flight Name</th>
                <th>Price</th>
                <th>Departure time</th>
                <th>Destination arrival time </th>
                
                
            </tr>
			<c:forEach var="flight" items="${sessionScope.Allticketslist}">
			<c:choose>
			<c:when test= "${flight.getTravellers().airlineUsername !=Username}">
              <td>${flight.getTravellers().airlineUsername}</td>
             
           </c:when>
           <c:otherwise>
                <tr>
                    <td>${flight.getFlightlist().flightName}</td>
                    <td>${flight.flightName}</td>
                    <td>$${flight.price}</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalTime}</td>
                   
               
               		<td> <input type="hidden" name="fid" value="${flight.fliID}" /></td>
                    <td><a id="foo" href="http://localhost:8081/airline/ProceedtoBook.htm?fid=${flight.fliID}"  id="link">Book Ticket</a></td>
                </tr>
                 </c:otherwise>
	</c:choose>   
         </c:forEach>
        </table> --%>
</form>

</body>
</html>