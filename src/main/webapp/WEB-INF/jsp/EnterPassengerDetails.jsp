<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Passenger details</h1>
<a> Enter the details of the traveller who would accompany you!</a>
<form action="./EnterPassengerDetails.htm" method="post" modelAttribute="PassengerDetails">
<%int noOfTravllers= (int) session.getAttribute("noOfTravllers");  %>
<table>
<tr/><th/>First Name<th/>Last Name<th/>Gender<th/>Email<th/>Date of birth<th/>Phone Number<th/>Address<th/>Passport Number
<% for (int i =0;i<noOfTravllers;i++){%>
	<tr/>
	<td/><input type="text" name="firstName"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="text" name="lastName"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="text" name="gender"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="email" name="email"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="text" name="dateOfBirth"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="text" name="phoneNum"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="text" name="address"<%=String.valueOf(i)%>" required = "required"/>
	<td/><input type="text" name="passportNo"<%=String.valueOf(i)%>" required = "required"/>
	
	<%}%>
	<tr/><td/>
	<input type="submit" name="submit" value="Verfiy the details">
	<input type="hidden" name="noOfTravllers" value="${sessionScope.noOfTravllers }"/>
	<%-- <input type="text" name="fid" value="${sessionScope.fid }"/> --%>
<%-- 	<%
	out.println(session.getAttribute("fid"));%> --%>
<%-- <c:forEach items = "i" var= "noOfTravllers">
<%out.print("dhg"+session.getAttribute("noOfTravllers")); %>
<tr>
    <td>First Name:</td>
    <td><input type="text" name="firstName" size="30" /></td>
</tr>
<tr>
    <td>Last Name:</td>
    <td><form:input type="text" name="lastName" size="30"/> <font color="red"><form:errors path="lastName"/></font></td>
</tr>
<tr>
    <td>Gender</td>
    <td><form:radiobutton value="Male" name="gender" checked="checked"/>Male
    	<form:radiobutton value="Female" name="gender" />Female
     </td>
</tr>
<tr>
    <td>Email:</td>
    <td><form:input type="text" name="email" id='email' size="30"/> <font color="red"><form:errors path="email"/></font></td>
</tr>
<tr>
    <td>Date of Birth:</td>
    <td><form:input type="text" name="dateOfBirth" id="dob" size="30"/> <font color="red"><form:errors path="dob"/></font></td>
</tr>
<tr>
    <td>Phone Number:</td>
    <td><form:input type="text" name="phoneNum" size="30" /> <font color="red"><form:errors path="phonenum"/></font></td>
</tr>
<tr>
    <td>Address:</td>
    <td><form:input type="textarea" name="address" size="30"/> <font color="red"><form:errors path="address"/></font></td>
</tr>

<tr>
    <td>Passport Number:</td>
    <td><form:input type="textarea" name="passportNo" size="30"/> <font color="red"><form:errors path="address"/></font></td>
</tr>
</c:forEach> --%>

</table>


</form>
<!-- <a href="ProceedtoBook.htm" >Change no of travellers</a> -->
</body>
</html>