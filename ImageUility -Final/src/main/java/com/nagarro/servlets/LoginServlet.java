package com.nagarro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nagarro.services.LoginImplementation;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<h1>hello </h1>" + request.getParameter("unm"));
		LoginImplementation login = new LoginImplementation();
		String username = request.getParameter("unm");
		String password = request.getParameter("pass");
		if (login.userAuthentication(username, password)) {
			com.nagarro.model.User user = login.getUserDetails(username);
			System.out.print(user);
			request.getSession().setAttribute("authorized", "true");
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
		} else {
			request.getSession().setAttribute("authorized", "false");
			response.sendRedirect("index.jsp");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
