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
<form action="./Payment.htm" method="get" modelAttribute="PaymentDetails">
<p> Verfiy the details of the flight for the user <b>${sessionScope.Username}</b></p>
<p>Flight details</p>
<%-- <h1>${sessionScope.flightlist}</h1> --%>
 <table border="1">
            <tr>
            	<th>Flight Number</th>
                <th>Flight Name</th>
                <th>Departure Date </th>
                <th>Departure time</th>
                <th>Arrival Date </th>
                <th>Arrival time </th>
                <th>Price</th>  
                <th>Travel Class</th>
                <th>No of Seats</th>
                <!-- <th>Available Seats</th> -->
            </tr>
            <%String fid = request.getParameter("fid");
            /* out.println(fid); */%>
			<c:forEach var="flight" items="${sessionScope.flightlist}">
			<c:choose>
			<c:when test= "${flight.fliID !=fid}">
              
           </c:when>
           <c:otherwise>
            <tr>
                    <td>${flight.fliID}</td>
                    <td>${flight.flightName}</td>
                    <td>${flight.departureDate}</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalDate}</td>
                    <td>${flight.arrivalTime}</td>
                    <td>$${flight.price}</td>
					
                    <td>${flight.travleClass}</td>
                    <td>${flight.totalSeats}</td>
                    
                    <%-- <td><a href="http://localhost:8081/airline/ProceedtoBook.htm?fid=${flight.fliID}"  id="link">Book Ticket</a></td> --%>
                </tr>  
               
               </c:otherwise>
                </c:choose>
         </c:forEach>
        </table>
        
        <p>Passenger details</p>
        <input type="hidden" name="noOfTravllers" value="noOfTravllers"/>
        <p>No of passengers: ${sessionScope.noOfTravllers}</p>
        <%--  <%int curr =Integer.valueOf(request.getParameter("curr"));
         out.println("curr:" + curr);
         int trav = Integer.valueOf(request.getParameter("noOfTravllers"));
         int totalAmount = curr * trav;%>
        <h1>Total Amount to be paid is: totalAmount</h1> --%>
        
        <input type="submit" value="Proceed to payment" />
        </form>
</body>
</html>