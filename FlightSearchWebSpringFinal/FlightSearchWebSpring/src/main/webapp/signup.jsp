<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
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

</style>
</head>
<body style="background-color: #222D32;font-size: 10px;
	color: #6C6C6C;	font-weight: bold;letter-spacing: 1px;">
		<jsp:include page="header.jsp" />

   <div class="container mt-5 mx-auto">
        <div class="row" style="background-color:#222D32;">
              <div class="col-lg pl-2" ><h5 class="text-primary">New User</h5> 
              </div>              
        </div>
        <div class="row" style="background-color:#222D32;;">
              <form action="signup" method="post" class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">        
                <div class="form-group row">
                       <label for="Name" class="col-sm-2 col-lg-3 col-form-label">Username:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="text" required class="form-control" style="height: 30px; border-radius: 0px;" name="unm">
                       </div>
                </div>
                <div class="form-group row">
                       <label for="Name" class="col-sm-2 col-lg-3 col-form-label">Phone:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="text" required class="form-control" style="height: 30px; border-radius: 0px;" name="phn">
                       </div>
                </div>
                <div class="form-group row">
                       <label for="Email" class="col-sm-2 col-lg-3 col-form-label">Password:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="password" required class="form-control" style="height: 30px; border-radius: 0px;" name="pass">
                       </div>
                </div>
                				<span class="font-weight-bold text-danger"> <%
 	if (session.getAttribute("error") != null) {
 %> <b><%=session.getAttribute("error")%></b> <%
 	session.setAttribute("error", null);
 	}
 %></span> 
 <br/>
                <div class="form-group row mb-0"style="background-color: #222D32;">
                  <div class="col-lg d-flex flex-row-reverse p-1 ml-2" style="background-color:#222D32;">
                      <input class="btn btn-primary pt-0 pr-3 pl-3" type="submit" value="Sign up &#187;">
                  </div>              
                </div>                                                                                                
              </form>
          </div>          
    </div>

</body>
</html>