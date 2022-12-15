<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter payment details</h1>
<form action="./bookedTickets.htm" method="post" >

<div>
<label>First Name</label>
<input type="text" name="FirstName" required="required"/>
</div>
</br>
<div>
<label>Last Name</label>
<input type="text" name="LastName" required="required"/>
</div>
</br>
<div>
<label>Bank Name</label>
<input type="text" name="BankName" required="required"/>
</div>
</br>
<div>
<label>Credit Card Number</label>
<input type="text" name="CreditCard" required="required"/>
</div>
</br>
<div>
<label>Expiration Date</label>
<input type="text" name="ExpirationDate" required="required"/>
</div>
</br>
<div>
<label>Expiration Month</label>
<input type="text" name="ExpirationTime" required="required"/>
</div>
</br>
<input type="submit" name="submit" value="Confirm and Book" />

</form>
</body>
</html>