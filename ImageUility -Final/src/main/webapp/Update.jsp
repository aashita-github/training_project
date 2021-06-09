<%@page import="org.hibernate.Query"%>
<%@page import="com.nagarro.model.Image"%>
<%@page import="com.nagarro.hibernate.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>

	<%
		System.out.println("Hello");
		long updateId = Long.parseLong(request.getParameter("updateId"));
		System.out.println(updateId);
		Session hibernateSession = HibernateUtil.getSessionInstance();
		Query query = hibernateSession.createQuery("FROM Image WHERE imageId = :imageId").setParameter("imageId",updateId);
		Image imageObject = (Image) query.uniqueResult();
	%>
	<div class="container mt-5 mx-auto">
		<div class="row">
			<div class="col-lg pl-2"
				style="background-color: rgb(225, 234, 243);">
				<h5 class="text-primary p-1">Update Image</h5>
			</div>
		</div>
		<div class="row" style="background-color: rgb(245, 248, 251);">
			<form action="ImageUpdate" method="post" enctype="multipart/form-data"
				class="col-sm-12 col-lg-12 col-md-12 mt-3 pl-2">

				<div class="form-group">
					<label for="recipient-name" class="col-form-label">Image Id</label>
					<input type="text" readonly name="id" value="<%=updateId%>"
						 class="form-control" id="recipient-name">
				</div>
				<div class="form-group">
					<label for="recipient-name" class="col-form-label">Name</label> <input
						type="text" class="form-control" name="newName"  value="<%=imageObject.getImageName()%>" id="recipient-name">
				</div>
				<div class="form-group">
					<label for="message-text" class="col-form-label">Image</label> <input
						type="file" class="form-control" name="newImage" id="message-text">
				</div>
				<div class="form-group row mb-0">
					<div class="col-lg d-flex flex-row-reverse p-2 ml-2"
						style="background-color: rgb(225, 234, 243);">
						<a class="btn btn-danger col-sm-1 p-2 m-1" href="home.jsp">Close
						</a> 
							<input class="btn btn-primary col-sm-1 p-2 m-1" type="submit" value="Update">
					</div>
				</div>

			</form>
		</div>
	</div>

	<script src="./js/bootstrap.min.js"></script>
</body>
</html>


