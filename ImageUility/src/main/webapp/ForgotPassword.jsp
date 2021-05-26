<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" href="./css/bootstrap.min.css"> 

   
</head>
<body>
<nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Image Management</a>
                </div>
                  <ul class="nav navbar-nav navbar-right">
                 
           <li><a href="index.jsp"><span
                        class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                        </ul>
            </div>
            </nav>
    <div class="container mt-5 mx-auto">
        <div class="row">
              <div class="col-lg pl-2" style="background-color:rgba(235,241,247,255);">
                  <h5 class="text-primary p-1"style="color:rgba(10,39,102,255);">Reset Password </h5>
              </div>              
        </div>
        <div class="row" style="background-color:rgba(245,248,251,255);">
              <form action="ResetPasswordServlet" method="post" class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">        
                <div class="form-group row">
                       <label for="Name" class="col-sm-2 col-lg-3 col-form-label">Username:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="text" required class="form-control"placeholder="Confirm Username" style="height: 30px; border-radius: 0px;" id="name" name="unm">
                       </div>
                </div>
                <div class="form-group row">
                       <label for="Name" class="col-sm-2 col-lg-3 col-form-label">Password:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="password" required class="form-control" placeholder="New Password"style="height: 30px; border-radius: 0px;"  name="pass">
                       </div>
                </div>
                <div class="form-group row">
                       <label for="Email" class="col-sm-2 col-lg-3 col-form-label">Confirm Password:</label>
                       <label style="color: red;">*</label>
                       <div class="col-sm-6 col-md-8 col-lg-5">
                           <input type="password" required class="form-control" placeholder="Confirm New Password"style="height: 30px; border-radius: 0px;" name="cpass">
                       </div>
                </div>
                <div class="form-group row mb-0">
                  <div class="col-lg d-flex flex-row-reverse p-1 ml-2" style="background-color:rgba(235,241,247,255);">
                      <input class="pt-0 pr-3 pl-3" style="border-color: rgba(142,165,187,255);border-radius: 5px;"type="submit" value="Next &#187;">
                  </div>              
                </div>                                                                                                
              </form>
          </div>          
    </div>
     <div class="text-center">
  
 <% if(session.getAttribute("passwordmessage") != null){ %>
 <p style="color: blue; text-align: center; font-weight: bold; font-family: Arial, Helvetica, sans-serif;">Message:
 <%= session.getAttribute("passwordmessage") %></p>
 <% session.setAttribute("passwordmessage", null);}
           
             %>
              </div>       
    

      
    </body>

<!-- <script src="./js/bootstrap.min.js"></script> -->
</body>
</html>