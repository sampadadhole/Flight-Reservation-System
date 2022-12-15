<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <title>Registartion Form</title>
</head>
<style>
	h1{text-align:center;}
	h2{text-align:center;}
	div{text-align:center;}
	div{margin:0.4rem;}
</style>
<body>
<!-- <script>
function clearthefeildSeleciton()
{
	document.getElementById("duplicateuser").innerHTML= "";
	document.getElementById("error").innerHTML= "";
}
function registerUser(){
	var isValid = true;
	var node = document.getElementById("error");
	
	var txtContent = node.textContent;
	
	
	if(txtContent=="Username already exists")
		{
		isValid = false;
		document.getElementById("duplicateuser").innerHTML= "";
		alert("Please enter unique username");
		}
	return isValid;
	
}
var xmlHttp;
xmlHttp = GetXmlHttpObject();
function checkUser() {
    if (xmlHttp == null)
     {
         alert("Your browser does not support AJAX!");
         return;
     }
     var username = document.getElementById("username").value;
     var query = "action=ajaxCheck&username="+username;
     xmlHttp.onreadystatechange = function stateChanged()
     {
         if (xmlHttp.readyState == 4)
         {
             //alert(xmlHttp.responseText);
             var json = JSON.parse(xmlHttp.responseText);
             document.getElementById("error").innerHTML="";
             document.getElementById("error").innerHTML = json.message;
             
         }
     };
     xmlHttp.open("POST", "register.htm", true);
     xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
     xmlHttp.send(query);
    return false;
 }
function GetXmlHttpObject()
{
    var xmlHttp = null;
    try
    {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e)
    {
        // Internet Explorer
        try
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xmlHttp;
}

</script> -->

</div>
<h2 align="center">Register a New User</h2>

<%-- <form:form action="register.htm?action=register" onSubmit="return registerUser()" method="post" commandName="airlineUsers">
<p>Username: <form:input type="text" path="username" id="username" onblur="return checkUser()" onclick="return clearthefeildSeleciton()" required="required" />
            <div id="error" style="color:red"></div>
 <p>Password: <form:input type="password" path="password" required="required"/></p>
            <input type="submit" value="Sign Up">
            <div id="duplicateuser"></div>

</form:form> --%>

<form method="post" name="contact-form" action="./register.htm" modelAttribute="airlineUsers">
		
		
		<div style="color: red">${error}</div>
		
		<br>
        <div class="form-group">
        	<input type="text" name="Username" placeholder="Username" required="required" min="5" max="20"/>
        </div>
		<div class="form-group">
            <input type="password"  name="Userpassword" placeholder="Password" required="required" />
        </div>
        <div class="form-group">
            <input type="UIN"  name="UIN" placeholder="UIN" required="required" />
        </div>
		      
		<div>
            <button type="submit">Sign in</button>
        </div>
	</form> 
<a href="login.htm"> Already have an account</a>

</body>
</html>
