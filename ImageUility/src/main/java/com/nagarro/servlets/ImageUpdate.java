package com.nagarro.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nagarro.services.ImageManagementImplementation;

@MultipartConfig(maxFileSize = 169999999)
public class ImageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageUpdate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("imageId") != null) {
			int id = Integer.parseInt(request.getParameter("imageId"));
			ImageManagementImplementation.deleteDetails(id);
			response.sendRedirect("home.jsp");

		} else {
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("newName"));
			int id = Integer.parseInt(request.getParameter("id"));

			String newImageName = request.getParameter("newName");
			Part filePart = request.getPart("newImage");
			InputStream fis = filePart.getInputStream();
			byte[] data = new byte[fis.available()];
			fis.read(data);

			long size = filePart.getSize() / 1024;
			ImageManagementImplementation.updateDetails(id, newImageName, data, size);
			response.sendRedirect("home.jsp");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
