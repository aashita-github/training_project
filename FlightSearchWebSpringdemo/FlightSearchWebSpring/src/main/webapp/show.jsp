<%@page import="com.nagarro.dto.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<%
ArrayList<Flight> available = new ArrayList<Flight>();
available = (ArrayList<Flight>) request.getAttribute("available");
%>
<head>
<meta charset="ISO-8859-1">
<title>Available Flights</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<style>
tr{
background-color:"rgb(255,255,255)";
}</style>
</head>
<body style="background-color: #222D32;">
		<jsp:include page="header.jsp" />

	<div class="container border border-secondary mx-auto mt-5">
		<div class="row border-bottom border-secondary">
			<div class="col-lg d-flex justify-content-center">
				<h5 class="p-1 text-dark"style="background-color:rgb(255,255,255)">Available Flights</h5>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 p-0">
				<div class="table-wrapper-scroll-y my-custom-scrollbar">
					<table class="table table-striped table-hover" style="font-size: 10px;
	color: #6C6C6C;	font-weight: bold;letter-spacing: 1px;">
						<thead class="thead" style="background-color:rgb(255,255,255)">
							<tr>
								<th>Flight.No</th>
								<th>Departure location</th>
								<th>Arrival location</th>
								<th>Flight Time</th>
								<th>Flight Class</th>
								<th>Fare</th>
								<th>Duration</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${available}" var="flight">
								<tr>
									<td>${flight.getFlight_no()}</td>
									<td>${flight.getDep_loc()}</td>
									<td>${flight.getArr_loc()}</td>
									<td>${flight.getFlight_time()}</td>
									<td>${flight.getFlight_class()}</td>
									<td>${flight.getFare()}</td>
									<td>${flight.getDuration()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="col-lg d-flex justify-content-center">
						<a class="btn btn-primary col-sm-2 p-2 m-1" align="Center"
							href="flightsearch">Search more </a> <a
							class="btn btn-primary col-sm-2 p-2 m-1" align="Center"
							href="login">Logout </a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>