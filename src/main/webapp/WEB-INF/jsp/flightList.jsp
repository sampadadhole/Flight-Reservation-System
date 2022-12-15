<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- <script>
document.getElementById('foo').onclick = function(){
    alert('Hello world');
}
</script> -->
<body>
<h1>Flightlist</h1>
<a>These are few of the flight which are found based on the search</a>
<%-- <c:choose>
            <c:when test="${!empty sessionScope.Username}">
                <jsp:include page="menu.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="menu2.jsp"/>
            </c:otherwise>
</c:choose> --%>
 <table border="1">
            <tr>
            	<th>Flight Number</th>
                <th>Flight Name</th>
                <th>Airplane Id</th>
                <th>Price</th>
                <th>Departure time</th>
                <th>Destination arrival time</th>
                <th>Available Seats</th>
            </tr>
			<c:forEach var="flight" items="${sessionScope.flightlist}">
                <tr>
                    <td>${flight.fliID}</td>
                    <td>${flight.flightName}</td>
                    <td>${flight.flightID}</td>
                    <td>$${flight.price}</td>
                    <td>${flight.departureTime}</td>
                    <td>${flight.arrivalTime}</td>
                   	<td>${flight.noSeatsAvaialable}</td> 
               
               		<td> <input type="hidden" name="fid" value="${flight.fliID}" /></td>
     
                    <td><a id="foo" href="http://localhost:8081/airline/ProceedtoBook.htm?fid=${flight.fliID}"  id="link">Book Ticket</a></td>
                </tr>   
         </c:forEach>
        </table>
        <a href="login.htm">Search more flights</a>
</body>
</html>