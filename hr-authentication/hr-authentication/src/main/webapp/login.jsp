<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.training.messages.FinalValues"%>
	
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<style>
	#labeluser{
margin-left:-80px;
margin-top:-80px;
}
#labelpass{
margin-left:-80px;

}

label{
color:#2d2f2e;
  font-weight: bold;}

</style>
</head>

<body class="bg-light">
<%-- <%
	if (session.getAttribute("authorized")!=null){  
		if(session.getAttribute("authorized").equals("true")){
		String redirectURL = "http://localhost:8080/hr-authentication/ok";
	    response.sendRedirect(redirectURL); 
	}}
%> --%>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="text-center">
		<fieldset id="fieldset1" style="border:1px solid #999;border-radius:7px;margin:60px auto;
  text-align: left; width:450px;height:340px;align:center;padding:6px;" >
		<legend style="width:auto;color:#6686c9;font-weight:bold;">Login</legend>
			<form class=" m-5 p-5" action="login" method="post">
				<div class="form-group row">
					<label class="col-form-label col-sm-2" id="labeluser" for="username">UserId:
					</label>
					<div class="col-sm-10">
						<input type="text" name="username" id="username" 
							placeholder="Username" style="width:300px;margin-top:-80px; 
  margin-bottom: 40px;margin-left:40px;"class="form-control" required maxlength="50">
					</div>
				</div>

				<div class="form-group row">
					<label class="col-form-label col-sm-2" id="labelpass" for="password">Password:
					</label>
					<div class="col-sm-10">
						<input type="password" style="width:300px;
  margin-bottom: 10px; margin-left:40px;"name="password" id="password"
							placeholder="Password" class="form-control" required>
					</div>
				</div>
				<input class="btn btn-primary col-sm-4 p-2 m-2" style="margin-right:70px;margin-top:-180px;margin-left:-30px;"type="submit"
					value="Log in"> <a class="btn btn-danger col-sm-4 p-2 m-2"
					href="signup" style="margin-top:-180px;">Sign Up </a>
<span class="font-weight-bold text-danger">
					<%
		if (session.getAttribute("error") != null) {
	%> <%=session.getAttribute("error")%> <a href="forgotpassword">Reset
						Password ?</a> <%
		session.setAttribute("error", null);
		}
	%>
			</span>
			</form>
			</fieldset>
		</div>
	</div>

	<br><br>
	<jsp:include page="footer.jsp" />
</body>
</html>