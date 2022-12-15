<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	h1{text-align:center;}
	form{text-align:center;}
	form{border: 0.2rem black solid;}
	form{margin:auto;}
	form{max-width:23rem;}
	form{padding: 1rem;}
	/* div{text-align:center;}
	div{margin:0.4rem;}
	input{text-align:center;} */
</style>
<body>
<h1>Register new company</h1>
<form method="post" name="contact-form" action="./addFlightCompanies.htm" modelAttribute="flightCompanies">

 <div class="form-group">
 	<label>Airline name</label>
   <input type="text" name="fightname"  required="required" "/>
 </div>
 </br>
 
  <div class="form-group">
 	<label>Airline Company</label>
   <input type="text" name="flightcompany"  required="required" "/>
 </div>
 </br>
 <div>
       <button type="submit">Add airline</button>
        </div>
 
</form>

</body>
</html>