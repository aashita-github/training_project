package com.nagarro.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.model.User;
import com.nagarro.services.ImageManagementImplementation;
import com.nagarro.services.LoginImplementation;

@WebServlet("/ImageDelete")
public class ImageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageDelete() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else {
			LoginImplementation login = new LoginImplementation();
			ImageManagementImplementation imageManagement = new ImageManagementImplementation();
			String imageId = request.getParameter("imageId").toString();
			imageManagement.deleteImage(imageId);
			System.out.println(imageId + "deleted");
			User userUpdated = login.getUserDetails(((User) request.getSession().getAttribute("user")).getUsername());
			request.getSession().setAttribute("user", userUpdated);
			response.sendRedirect("home.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
