package com.nagarro.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.nagarro.model.Image;
import com.nagarro.model.User;
import com.nagarro.services.ImageManagementImplementation;
import com.nagarro.services.LoginImplementation;

@MultipartConfig(maxFileSize=169999999)
public class ImageUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ImageUpload() {
        super();
            }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 if (request.getSession().getAttribute("user") == null) {
             response.sendRedirect("index.jsp");
         } else {
             String imageName = null;
             byte bytes[] = null;
             double imageSize = 0;
               if (ServletFileUpload.isMultipartContent(request)) {
                 try {
                     List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                     for (FileItem item : multiparts) {
                         if (item.isFormField()) {
                             imageName = item.getName();
                         } else {
                        	 imageName=item.getName();
                             imageSize = item.getSize() / 1024;
                             bytes = item.get();
                         }
                         System.out.print(imageName);
                     }
                     //File uploaded successfully
                     request.setAttribute("message", "File Uploaded Successfully");
                     User user = (User) request.getSession().getAttribute("user");
                     Image image = new Image(imageName, imageSize, bytes);
                     image.setUser(user);
                     if (user != null) {
                         if (image.getImageSize() < 1024) {
                             //changes...addedd current image size
                             if (GetImagesSizes.getImagesSize(user.getUsername()) + image.getImageSize() < 10240) {
                                 ImageManagementImplementation imageManagement = new ImageManagementImplementation();
                                 imageManagement.addImage(image);
                                 try {
                                     LoginImplementation login = new LoginImplementation();

                                     User userUpdated = login.getUserDetails(((User) request.getSession().getAttribute("user")).getUsername());
                                     request.getSession().setAttribute("user", userUpdated);
                                     response.sendRedirect("home.jsp");
                                 } catch (Exception e) {
                                     e.printStackTrace();
                                 }
                             } else {
                                 System.out.println("Images size exceeded > 10 MB");
                                 response.sendRedirect("home.jsp");
                             }
                         } else {
                             System.out.println("Image size exceeded");
                             response.sendRedirect("home.jsp");
                         }
                     }
                 } catch (Exception ex) {
                     request.setAttribute("message", "File Upload Failed due to " + ex);
                 }

             } else {
                 request.setAttribute("message", "Sorry image could not be uploaded");
             }
         }
         //response.sendRedirect("userhome.jsp");
     }
       	}