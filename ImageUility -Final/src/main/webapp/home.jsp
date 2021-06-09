<%@page import="com.nagarro.model.User"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="com.nagarro.model.Image"%>
<%@page import="com.nagarro.hibernate.HibernateUtil"%>

<%@page import="com.nagarro.services.LoginImplementation" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<!-- Bootstrap core css -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- Image Custom css -->
<link rel="stylesheet" href="./css/image.css">
</head>
<body>
   <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Image Management</a>
                </div>
                  <ul class="nav navbar-nav navbar-right">
                 
           <li><a href="logout.jsp"><span
                        class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                        </ul>
            </div>
            </nav>
	<div class="container border border-secondary mx-auto mt-5">
		<div class="row border-bottom border-secondary">
			<div class="col-lg d-flex justify-content-center">
				<h5 class="p-1 text-dark">Image Management Utility</h5>
			</div>
		</div>
		<form action="ImageUpload" method="post" class="row"
			enctype="multipart/form-data">
			<div class="col-lg-8">
				<p class="col-sm-12 col-lg-12">Please select an image file to
					upload (Max Size 1 MB)</p>
				<div class="col-sm-6 col-md-8 col-lg-6">
					<input type="text" placeholder="enter image name" name="name">
					<input type="file" id="selectedFile" name="image"
						style="display: none;" /> <input type="button" value="Browse"
						onclick="document.getElementById('selectedFile').click();" />
				</div>
			</div>
			<div class="col-md-12 col-lg-4 col-sm-12 mt-3 p-4">
				<div class="d-flex justify-content-center">
					<input class="mr-2" type="submit" name="addImage" value="Submit" />
					<input type="reset" value="Cancel" />
				</div>

			</div>
		</form>
		<div class="row">
			<div class="col-lg-12">
				<h5>Uploaded Images</h5>
			</div>
			<div class="col-lg-12 p-0">
				<div class="table-wrapper-scroll-y my-custom-scrollbar">
					<table class="table table-bordered" id="studentList">
						<thead class="text-dark">
							<tr>
								<th>S.No</th>
								<th>Name</th>
								<th>Size</th>
								<th>Preview</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<%!String name, printSize;
								double size;
								long imageId;
								int count = 0;%>
							<%
							User user = (User)session.getAttribute("user");
							int id=user.getId();
							System.out.println(user);
							/* user.setUsername(userName); */
							List<Image> imageList = LoginImplementation.getAllDetails(id);
							Iterator<Image> it = imageList.iterator();
							count = 0;
							while (it.hasNext()) {
								
								Image imageObject = (Image) it.next();
								if(imageObject.getUser().getId()==user.getId()){
								byte[] image = imageObject.getPhoto();
								String imgDataBase64 = new String(Base64.getEncoder().encode(image));
								imageId = imageObject.getImageId();
								name = imageObject.getImageName();
								size = imageObject.getImageSize()/1024;
								
								printSize =String.format("%.3g%n",size)+ " MB";
							%>
							<tr>
								<td><%=++count%></td>
								<td><%=name%></td>
								<td><%=printSize%></td>
								<td><img alt="image" style="width: 180px; height: 100px"
									src="data:image/jpg;base64,<%=imgDataBase64%>"></td>
								<td><a href="Update.jsp?updateId=<%=imageId%>"><img
										alt="updateImage" style="width: 20px; height: 20px"
										src="edit.jpg"></a> &nbsp; <a
									href="ImageDelete?imageId=<%=imageId%>"><img
										alt="deleteImage" style="width: 20px; height: 20px"
										src="delete.png"></a></td>
							</tr>
							<%
								}
							}
							double total=LoginImplementation.getTotalSize()/1024 ;
							%>
						
						</tbody>
				
					</table>
				</div>
			</div>
		</div>
			<footer class="row text-center"> <h5>Size of Image files <%=String.format("%.2g%n",total)%> MB</h5></footer>
	</div>

	<script type="text/javascript" src="./jquery/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.min.js"></script>
			
				</body>
</html>