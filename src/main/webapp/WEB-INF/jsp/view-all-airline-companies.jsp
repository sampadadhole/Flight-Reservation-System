<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>View all flight companies</h1>
<form action="./ViewAllCompanies.htm" method="get" modelAttribute="CompanyDetails">
 <table border="1">
            <tr>
            	
               <th>Company ID</th>
                <th>Company Name</th>
                <th>Owner</th>
                
            </tr>
			<c:forEach var="comp" items="${sessionScope.companies}">
			<%-- <c:set var="id" value="${schoolDetails.value}"/> --%>
                <tr>
                   	<td>${comp.flightiD}</td>
                    <td>${comp.fightname}</td>
                    <td>${comp.flightcompany}</td>
         			<td> <input type="hidden" name="admin_flight_id" value="${comp.flightiD}" /></td>
                    <td><a href="EditFlightCompany.htm?flight_id=${comp.flightiD}"  id="link">Edit Flight</a></td>
       				<td><a href="deleteFlight.htm?flight_id=${comp.flightiD}"  id="link">Delete Flight</a></td>
                </tr>   
         </c:forEach>
        
        </table>
	
</form>

</body>
</html>