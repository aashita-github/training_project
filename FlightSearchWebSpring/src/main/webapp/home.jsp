
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
    background: #222D32;
font-family: 'Roboto', sans-serif;
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
.label{
font-size: 10px;
color: #6C6C6C;
font-weight: bold;
letter-spacing: 1px;
}
input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #4169E1;
}

input[type=date], select {
	width: 100%;
	padding: 12px; /* Some padding */
	border: 1px solid #ccc; /* Gray border */
	border-radius: 4px; /* Rounded borders */
	margin-top: 3px; /* Add a top margin */
	margin-bottom: 3px; /* Bottom margin */
}
header{
font-weight: bold;
color: #ECF0F5;
}
</style>
<title>Home</title>
</head>
<body>

	<header>
		<div>
			<table width="100%">
				<tr>
					<td>
						<h2>
							Welcome
							<c:out value="${uId}" />
							! You can search your flight here.
						</h2>
					</td>
					<td align="right">
						<form action="SignOut">
							<input type="submit" value="SignOut" />
						</form>
					</td>
				</tr>
			</table>
		</div>
	</header>
	<div align="center" class="container">
		<form action="search" method="get">
			<table>
				<tr>
					<td class="label">From : <label style="color: red;">*</label>
					</td>
					<td><select name="from">
							<c:forEach items="${fromAirportCodes}" var="fromAirportCode">
								<option value="${fromAirportCode}">${fromAirportCode}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="label">To : <label style="color: red;">*</label>
					</td>
					<td ><select name="to">
							<c:forEach items="${toAirportCodes}" var="toAirportCode">
								<option value="${toAirportCode}">${toAirportCode}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="label">Date : <label style="color: red;">*</label>
					</td>
					<td><input type="date" name="date" /></td>
				</tr>
				<tr>
					<td class="label">Class : <label style="color: red;">*</label>
					</td>
					<td><select name="class">
							<option value="E">Economy</option>
							<option value="B">Business</option>
					</select></td>
				</tr>
				<tr>
					<td class="label">Sort by : <label style="color: red;">*</label>
					</td>
					<td><select name="sortBy">
							<option value="1">Fare</option>
							<option value="2">Fare & Flight Duration</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" style="float:right;" value="Search" /></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>