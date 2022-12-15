<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	h2{text-align:center;}
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
<h2> Welcome ${sessionScope.Username}</h2>

<form  name="contact-form" action="./ShowFlightList.htm" modelAttribute="flightsList" method="post">

<div class="form-group">
<label>From:</label>
      <input type="text" name="From" placeholder="from" required="required"/>
</div>
</br>

<div class="form-group">
<label>To:</label>
      <input type="text" name="To" placeholder="to" required="required"/>
</div>
</br>
<div class="form-group">
<label>Departure date:</label>
      <input type="date" name="dep_date" id="userdate" required="required" onchange="DeptDate()"/>
</div>
</br>
<div class="form-group">
<label>Arrival date:</label>
      <input type="date" name="arr_date" id="arrdate" required="required" onchange="ArrDate()" />
</div>
</br>
<div class="form-group">
<label>Travel class:</label>
	<label for >Economy</label>
      <input type="radio" id="trav_class"  name="Economy"/>
      
      <label for>Business</label>
      <input type="radio" id="trav_class"  name="Business"/>
</div>
</br>
<input type="submit" />
<br/>
</form>
<a href="account.htm">Account</a><br/>
<br/>

</body>
<script>
function DeptDate() {
	
    var UserDate = document.getElementById("userdate").value;
    console.log(UserDate)
    var ToDate = new Date();
    console.log(ToDate)

    if (new Date(UserDate).getTime() < ToDate.getTime()) {
          alert("Please do not select the past dates");
          document.getElementById("userdate").value=null
          return false;
     }
    return true;
}
function ArrDate() {
	
    var arrDate = document.getElementById("arrdate").value;
    var deptDate = document.getElementById("userdate").value;
    console.log(deptDate)
    var ToDate = new Date();
    console.log(arrDate)

    if (arrDate < deptDate) {
          alert("Arrival date is less than departure date. Please select arrival date greater than departure date");
          document.getElementById("arrdate").value=null
          return false;
     }
    return true;
}

</script>

</html>