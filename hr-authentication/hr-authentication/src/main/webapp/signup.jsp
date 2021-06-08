<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<style>
label{
font-weight:bold;}</style>
</head>
<body class="bg-light">
	<jsp:include page="header.jsp" />
	<br />
	<div class="container">
	<fieldset class="border p-2" style="height:450px;border-radius:7px;">
		<legend class="w-auto medium" style="color:#6686c9;font-weight:bold;">Sign Up</legend>
		<div class="text-center">
			<form id="myForm" class=" m-5 p-5" method="post" action="signup" >

				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="username">Username
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="username"
							id="username" placeholder="Username" required>
					</div>
				</div>
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="phone">Mobile
						Number </label>
					<div class="col-sm-10">
						<input class="form-control" type="text" name="phone" id="phone"
							placeholder="Mobile Number" required>
					</div>
				</div>
				<div class="text-left form-group row">
					<label class="col-form-label col-sm-2" for="password">Password
					</label>
					<div class="col-sm-10">
						<input class="form-control" type="password" name="password"
							id="password" placeholder="Password" required><br>
					</div>
				</div>
				<span class="font-weight-bold text-danger"> <%
 	if (session.getAttribute("error") != null) {
 %> <b><%=session.getAttribute("error")%></b> <%
 	session.setAttribute("error", null);
 	}
 %></span> 
 <br/>
 <input class="text-center btn btn-primary col-sm-6 p-2 m-2"
					type="button" value="Sign Up" onclick="submitAction()">
			</form>
		</div>
		</fieldset>
	</div>
	<br><br>
	<jsp:include page="footer.jsp" />
	
	<script type="text/javascript"> 
        function submitAction() {
        	var phonenoexp = /^\d{10}$/;
        	var username=document.getElementById("username").value;
        	var phoneno = document.getElementById("phone").value;
        	var password = document.getElementById("password").value;
        	if(!phoneno.match(phonenoexp)){
        		alert( "Mobile number must be of 10 digits.");
        	}
        	else if(password.length<6){
        		alert( "Password cannot be less than 6 characters.");
        	}
        	else if(password.length>50){
        		alert( "Password cannot be greater than 50 characters.");
        	}
        	else if(username.length<6){
        		alert( "Username cannot be less than 6 characters.");	
        	}
        	else if(username.length>50){
        		alert( "Username cannot be greater than 50 characters.");	
        	}
          	else{
        		document.getElementById("myForm").submit();
        	}
        } 
    </script>
</body>
</html>