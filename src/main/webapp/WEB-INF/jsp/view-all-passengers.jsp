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
<h1>View All passengers</h1>
<form action="./ViewAllPassengers.htm" method="get">

 <table border="1">
            <tr>
            	
               
                <th>Traveller First Name</th>
                <th>Traveller Last Name</th>
                <th>Traveller gender</th>
                <th>Traveller Email</th>
                <th>Traveller  Date Of Birth</th>
                <th>Traveller Email Address </th>
                <th>Traveller Passport No</th>
                <th>Traveller Phone Number</th>
                
            </tr>
   
			<c:forEach var="trav" items= "${sessionScope.travellers}">
			<%-- <c:set var="id" value="${schoolDetails.value}"/> --%>
                <tr>
                   	
                    <td>${trav.firstName}</td>
                    <td>${trav.lastName}</td>
                    <td>${trav.gender}</td>
                    <td>${trav.email}</td>
                    <td>${trav.dateOfBirth}</td>
                   <td>${trav.address}</td> 
                   <td>${trav.passportNo}</td> 
                   <td>${trav.phoneNum}</td>
         			<%-- <td> <input type="text" name="flightid" value="${flight.fliID}" /></td>
                    <td><a href="EditFlightDetails.htm?fli_id=${flight.fliID}"  id="link">Edit Flight</a></td>
       				<td><a href="delete-flight-details.htm?fli_id=${flight.fliID}"  id="link">Delete Flight</a></td> --%>
                </tr>   
         </c:forEach>
        
        </table>
	
</form>
</body>
</html>