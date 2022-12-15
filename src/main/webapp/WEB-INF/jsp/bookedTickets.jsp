<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ticket has been booked successfully!</h1>
<form method="post" name="contact-form" action="./confirmation.htm" modelAttribute="emailticket">

<input type="email" name="email" required="required" />
<input type= "submit" name="submit" value="Email Ticket" />


</form>
</br>
<a href="downloadTicket.pdf">Download Ticket</a>
</body>
</html>