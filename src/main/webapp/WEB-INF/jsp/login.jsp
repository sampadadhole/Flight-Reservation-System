<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
</head>
<style>
	h1{text-align:center;}
	h2{text-align:center;}
	div{text-align:center;}
	div{margin:0.4rem;}
</style>

<body>

<%boolean isValid = false; 
%>
<form method="post" name="contact-form" action="./login.htm" modelAttribute="airlineUsers">
		<h2>Login</h2>
		
		<div style="color: red">${isValid}</div>
		
		<br>
        <div class="form-group">
        	<input type="text" name="Username" placeholder="username" required="required"/>
        </div>
		<div class="form-group">
            <input id="pswrd" type="password" name="Userpassword" placeholder="Password" required="required" onkeypress="passwordValid()" />
        </div>
		      
		<div>
            <button type="submit">Sign in</button>
        </div>
	</form>
	<a href="register.htm"> New User? Register here</a>
</body>

<script>


  const pswrd = document.querySelector("#pswrd");
  let value = "";
  pswrd.addEventListener("event", e => {
	value = e.target.value;
	  }); 
 
function passwordValid(){ 
	
	console.log(value.length)
}
</script>
</html>