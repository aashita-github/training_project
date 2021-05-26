package com.nagarro.servlets;

import com.nagarro.model.User;
import com.nagarro.services.LoginImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		request.getSession().setAttribute("message", "");
		LoginImplementation login = new LoginImplementation();
		String username = request.getParameter("unm");
		String password = request.getParameter("pass");
		System.out.println("Username : " + username);
		System.out.println("Password : " + password);
		String passwordConfirm = request.getParameter("cpass");
		User user = login.getUserDetails(username);

		if (user != null) {
			if (password.equals(passwordConfirm)) {
				if (user.getUsername().equalsIgnoreCase(username)) {
					int id = user.getId();
					login.updatePassword(id, username, password);
					request.getSession().setAttribute("passwordmessage", "Password Updated Successfully");
					message = "Success";

				} else {
					request.getSession().setAttribute("passwordmessage",
							"One of the given information is incorrect... (Full Name)");
					message = "One of the given information is incorrect... (Full Name)";
				}
			} else {
				request.getSession().setAttribute("passwordmessage", "Password does not match");
				message = "Password does not match";
			}
		} else {
			request.getSession().setAttribute("passwordmessage", "No user exists with such username");
			message = "No user exists with such username";
		}
		System.out.println(message);

		response.sendRedirect("ForgotPassword.jsp");
	}

}