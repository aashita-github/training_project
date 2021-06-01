<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Flight</title>
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
 input[type=date] {
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
select{
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
 
 
.search-title {
	margin-top: 15px;
	text-align: center;
	font-size: 30px;
	letter-spacing: 2px;
	margin-top: 15px;
	font-weight: bold;
	color: #ECF0F5;
}</style>
</head>
<body style="background-color: #222D32;font-size: 10px;
	color: #6C6C6C;	font-weight: bold;letter-spacing: 1px;">
	<jsp:include page="header.jsp" />

	<div class="container mt-5 mx-auto">
		<div class="row">
			<div class="col-lg pl-2"
				style=" background-color: #1A2226;;">
			<div class="col-lg-12 search-title text-center">Search Flight</div>
			</div>
		</div>
		<div class="row" style="background-color: #1A2226;;">
			<form action="flightsearch" method="post"
				class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 col-form-label">Departure
						Location:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="text" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="dep_loc">
					</div>
				</div>
				<div class="form-group row">
					<label for="Email" class="col-sm-2 col-lg-3 col-form-label">Arrival
						Location:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="text" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="arr_loc">
					</div>
				</div>
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 col-form-label">Flight
						Date:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<input type="date" required class="form-control"
							style="height: 30px; border-radius: 0px;" name="flight_date">
					</div>
				</div>
				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 col-form-label">Flight
						Class:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">

						<select name="flight_class" required class="form-control">
							<option value="" disabled selected>Select Flight Class</option>
							<option>Economy</option>
							<option>Business</option>
						</select>
					</div>
				</div>

				<div class="form-group row">
					<label for="Name" class="col-sm-2 col-lg-3 col-form-label">Output
						Preference:</label> <label style="color: red;">*</label>
					<div class="col-sm-6 col-md-8 col-lg-5">
						<select name="output_preference" required class="form-control">
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
				</span><br />
				<div class="form-group row mb-0">
					<div class="text-center col-lg d-flex flex-row-reverse p-1 ml-2"
						style=" background-color: #1A2226;;">
						<input class="btn-primary pt-0 pr-3 pl-3" type="submit" value="Search &#187;">
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>