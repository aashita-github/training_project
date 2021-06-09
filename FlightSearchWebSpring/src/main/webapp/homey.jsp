<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<STYLE>body {
    background: #222D32;
font-family: 'Roboto', sans-serif;
}
.form-group {
margin-bottom: 40px;
outline: 0px;
}

input[type="text"]{
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
.drop{
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
.out{
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
input[type="date"]{
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
.search-box {
margin-top: 15px;
height: auto;
background: #1A2226;
text-align: center;
box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}

.form-control:focus {
border-color: inherit;
-webkit-box-shadow: none;
box-shadow: none;
border-bottom: 2px solid #0DB8DE;
outline: 0;
background-color: #1A2226;
color: #ECF0F5;
}
.form-control-label {
font-size: 10px;
color: #6C6C6C;
font-weight: bold;
letter-spacing: 1px;
}
.search-title {
margin-top: 15px;
text-align: center;
font-size: 30px;
letter-spacing: 2px;
margin-top: 15px;
font-weight: bold;
color: #ECF0F5;
}
.container{

margin-top: 75px;
height: auto;
background: #1A2226;
text-align: center;
box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
}
</STYLE>
</head>
<body>
<nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Airline</a>
                </div>
                  <ul class="nav navbar-nav navbar-right">
                 
           <li><a href="logout.jsp"><span
                        class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                        </ul>
            </div>
            </nav>

	<div class="container mt-5 mx-auto">
		<div class="row">
			<div class="col-lg pl-2 search-box">
				<h5 class="text p-1 search-title">Search Flight</h5>
			</div>
		</div>
		<div class="row box">
			<form action="search" method="get"
				class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 form-control-label">Departure
						Location:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="text" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="dep_loc">
					</div>
				</div>
				<div class="form-group row">
					<label for="Email" class="col-sm-2 col-lg-3 form-control-label">Arrival
						Location:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="text" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="arr_loc">
					</div>
				</div>
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 form-control-label">Flight
						Date:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="date" required class="form-control drop"
							style="height: 30px; border-radius: 0px;" name="flight_date">
					</div>
				</div>
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 form-control-label">Flight
						Class:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">

						<select name="flight_class" required class="form-control drop">
							<option value="" disabled selected>Select Flight Class</option>
							<option>Economy</option>
							<option>Business</option>
						</select>
					</div>
				</div>

				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 form-control-label">Output
						Preference:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<select name="output_preference" required class="form-control out">
							<option value="" disabled selected>Select Output
								Preference</option>
							<option>Fare</option>
							<option>Both</option>
						</select>
					</div>
				</div>
				<span class="font-weight-bold text-danger"> <%
 				if (session.getAttribute("error") != null) {
				 %> <b><%=session.getAttribute("error")%></b> <%
				 session.setAttribute("error", null);
 				}
 				%>
				</span>
				<div class="form-group foot row mb-0">
					<div class="foot col-lg d-flex flex-row-reverse p-1 ml-2">
					    <button type="submit" class="btn btn-outline-primary">SEARCH</button>
				
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>