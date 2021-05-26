package com.nagarro.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.nagarro.model.User;
import com.nagarro.services.ImageManagementImplementation;
import com.nagarro.services.LoginImplementation;

@MultipartConfig(maxFileSize = 169999999)
@WebServlet("/ImageEdit")
public class ImageEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageEdit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		com.nagarro.model.User user = (User) request.getSession().getAttribute("user");
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		} else {
			LoginImplementation login = new LoginImplementation();
			String imageId = request.getParameter("imageId");
			ImageManagementImplementation imageManagement = new ImageManagementImplementation();
			com.nagarro.model.Image img = imageManagement.getImage(imageId);
			float currentImageSize = (float) img.getImageSize();
			double imageSize = 0;
			byte[] bytes = null;
			String imageName = null;

			response.setContentType("text/html;charset=UTF-8");
			try {
				if (!ServletFileUpload.isMultipartContent(request)) {
					System.out.println("sorry. No file uploaded");
					return;
				}

				// Apache Commons-Fileupload library classes
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

				// parse request
				List<FileItem> items = servletFileUpload.parseRequest(request);
				System.out.println(items.size());

				for (FileItem file : items) {
					if (file.isFormField()) {
						imageName = file.getString();
						if (!imageName.isEmpty()) {
							img.setImageName(imageName);
						}
					} else {
						imageSize = file.getSize() / 1024;
						if (imageSize != 0) {
							bytes = file.get();
							img.setImageSize(imageSize);
							img.setPhoto(bytes);
						}
					}
				}
			} catch (Exception e) {
				System.err.println("Error occurred ");
			}

			if (img.getImageSize() > 1024
					|| (GetImagesSizes.getImagesSize(user.getUsername()) + imageSize - currentImageSize) > 10240) {
				System.out.println("Image size exceeded");
			} else {
				imageManagement.editImage(img);
			}
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
