<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"> 

</head>
<body>
 <div class="container mt-5 mx-auto">
  
            <h2 class="text-center">Image Management</h2>
            <br/>
           
        <div class="row">
              <div class="col-lg pl-2" style="background-color:rgba(235,241,247,255);">
                  <h5 style="color:rgba(10,39,102,255);"><b>Login</b></h5>
              </div>              
        </div>
        <div class="row" style="background-color:rgba(245,248,251,255);">
              <form action="LoginServlet" method="post" class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">        
                <div class="form-group row" style="background-color:rgba(245,248,251,255)">
                       <label for="Name" class="col-sm-2 col-lg-3 col-form-label">Username:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="text" required class="form-control" style="height: 30px; border-radius: 0px;"  name="unm">
                       </div>
                </div>
                <div class="form-group row" style="background-color:rgba(245,248,251,255)">
                       <label for="Email" class="col-sm-2 col-lg-3 col-form-label">Password:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="password" required class="form-control" style="height: 30px; border-radius: 0px;" name="pass">
                       </div>
                </div>
                <div class="form-group row">                 
                <label for="Email" class="col-sm-2 col-lg-3 col-form-label"></label>      
                       <div class="col-sm-6 col-md-8 col-lg-6" >
                         <p >  <a href="ForgotPassword.jsp"style="text-decoration:underline;text-decoration-color:rgba(235,241,247,255);">Forgotten Your Password?</a></p>
                       </div>
                </div>
                <div class="form-group row mb-0">
                  <div class="col-lg d-flex flex-row-reverse p-1 ml-2" style="background-color:rgba(235,241,247,255);">
                      <input class="pt-0 pr-3 pl-3" type="submit" id="btn" style="border-color: rgba(142,165,187,255);border-radius: 5px;"value="Login &#187;">
                  </div>              
                </div>                                                                                                
              </form>
               
          </div>   
            <div class="text-center">
 <% if (session.getAttribute("authorized") != null && session.getAttribute("authorized").equals("false"))
            { %>
            <p style="color: crimson; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif;">Invalid credentials </p>
            <% session.setAttribute("authorized", null);
            } %>
              </div>       
    </div>
  
</body>
</html>