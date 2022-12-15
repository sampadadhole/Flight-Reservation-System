<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Account Details</h1>
<!-- <form method="post" name="contact-form" action="./signout.htm" modelAttribute="airlineUsers"> -->
<p>Username: ${sessionScope.Username}</p>
<!-- <input type="submit" name="submit" value="Sign out" /></br> -->
<a href="account/ViewBookedFLightsHistory.htm">ViewBookedFlights</a></br> 
<a href="login.htm" > Go to User home page</a></br>
<a href="signout.htm">Sign out</a>
<!-- </form> -->
</body>
</html>