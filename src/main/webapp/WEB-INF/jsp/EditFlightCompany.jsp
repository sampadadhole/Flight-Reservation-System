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
<% String flight_id = (String) session.getAttribute("flight_id"); %>

<h1>Edit the flight company for ${flight_id}</h1>

<form action="./successEditFlightdetails.htm" method="post" modelAttribute="EditCompany">


	<div>
	<label>Flight Number:</label>
	<input type="text" name="flight_id" value="${flight_id}" readonly />
	</div>
	</br>
	<div>
	<label>Flight Name</label>
	<input type="text" name="updated_company_name" required="required"  />
	</div>
	</br>
	<div>
	<label>Updated Company Owner</label>
	<input type="text" name="updated_company_owner" required="required"/>
	</div>
	</br>
        <input type="submit" value="Update details" />
     </form>

</body>
</html>