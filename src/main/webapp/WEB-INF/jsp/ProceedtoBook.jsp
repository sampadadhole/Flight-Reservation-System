<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String fid = request.getParameter("fid");
	

	session.setAttribute("fid", fid);%>
<form action="./EnterPassengerDetails.htm" method="get" modelAttribute="CheckoutPassengerDetails">

	
	<h1>Please enter the number of travellers:</h1>
	
	<input type="number" name= "noOfTravllers" required="required"/>
	
	<input type="hidden" name="fid" value="fid:${sessionScope.fid}"/>
	<input type="submit" value="submit" />
	
</form>

</body>
</html>