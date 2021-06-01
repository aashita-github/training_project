<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<style>
input[type=text] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    outline: 0;
    margin-bottom: 20px;
    padding-left: 0px;
    color: #ECF0F5;
}
 
input[type=password] {
    background-color: #1A2226;
    border: none;
    border-bottom: 2px solid #0DB8DE;
    border-top: 0px;
    border-radius: 0px;
    font-weight: bold;
    outline: 0;
    padding-left: 0px;
    margin-bottom: 20px;
    color: #ECF0F5;
}
.login-title {
	margin-top: 15px;
	text-align: center;
	font-size: 30px;
	letter-spacing: 2px;
	margin-top: 15px;
	font-weight: bold;
	color: #ECF0F5;
}
.login-box {
	margin-top: 75px;
	height: auto;
	background-color: #1A2226;
	text-align: center;
	box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}</style>
</head>
<body style="background-color: #222D32;font-size: 10px;
	color: #6C6C6C;	font-weight: bold;letter-spacing: 1px;">
		<jsp:include page="header.jsp" />
	<div class="container mt-5 mx-auto">
		<div class="row">
			<div class="col-lg pl-2 login-box"
>
				<div class="col-lg-12 login-title text-center">USER PANEL</div>
				
			</div>
		</div>
		<div class="row" style="background-color: #1A2226;">
			<form action="login" method="post"
				class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 col-form-label">Username:</label>
					<label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="text" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="unm">
					</div>
				</div>
				<div class="form-group row">
					<label for="Email" class="col-sm-2 col-lg-3 col-form-label">Password:</label>
					<label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="password" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="pass">
					</div>
				</div>
				<span class="font-weight-bold text-danger"> <%
 					if (session.getAttribute("error") != null) {
 					%> <%=session.getAttribute("error")%> <%
 					session.setAttribute("error", null);
 					}
					 %>
				</span>
				<div class="form-group row">
					<label for="Email" class="col-sm-2 col-lg-3 col-form-label"></label>
					<div class="col-sm-6 col-md-8 col-lg-6">
						<a href="forgotpassword">Forgot password?</a>
					</div>
				</div>
				<div class="form-group row">
					<label for="Email" class="col-sm-2 col-lg-3 col-form-label"></label>
					<div class="col-sm-6 col-md-8 col-lg-6">
						<a href="signup">New User</a>
					</div>
				</div>
				<div class="form-group row mb-0">
					<div class="col-lg d-flex flex-row-reverse p-1 ml-2"
						style="background-color: #1A2226;">
						<input class="btn btn-primary pt-0 pr-3 pl-3" type="submit"
							value="Login &#187;">
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>