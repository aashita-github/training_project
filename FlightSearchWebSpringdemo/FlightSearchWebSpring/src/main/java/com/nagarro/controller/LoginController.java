package com.nagarro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.constants.FinalValues;
import com.nagarro.service.LoginService;

@Controller
@SessionAttributes({ FinalValues.USER, FinalValues.AUTHORIZED, FinalValues.ERROR })
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("unm");
		String password = request.getParameter("pass");
		boolean userAuthenticated = loginService.loginAuthentication(username, password);

		if (userAuthenticated) {

			mv.addObject(FinalValues.AUTHORIZED, "true");
			username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();
			mv.addObject(FinalValues.USER, username);
			mv.setViewName("flightsearch");
		} else {
			mv.addObject(FinalValues.ERROR, "Username or Password is Invalid.");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signInGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signIn(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("unm");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phn");
		boolean usernameAvailable = loginService.usernameVerify(username);

		if (usernameAvailable) {
			loginService.signUp(username, password, phone);
			mv.setViewName("redirect:login");
		} else {
			mv.addObject(FinalValues.ERROR, "Username not available.");
			mv.setViewName("signup");
		}
		return mv;
	}
	

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView forgetPasswordGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forget");
		return mv;
	}


	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public ModelAndView forgetPassword(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("unm");
		String password = request.getParameter("pass");
		String passwordConfirm = request.getParameter("cpass");
		String phone = request.getParameter("phn");
		if (password.equals(passwordConfirm)) {
			boolean usernamePhoneMatched = loginService.usernameAndPhoneVerify(username, phone);
			if (usernamePhoneMatched) {
				loginService.forgetPassword(username, password);
				mv.setViewName("redirect:login");
			} else {
				mv.addObject(FinalValues.ERROR, "Mobile number and username not associated.");
				mv.setViewName("forget");
			}
		} else {
			mv.addObject(FinalValues.ERROR, "Passwords didn't matched.");
			mv.setViewName("forget");
		}
		return mv;
	}

}
