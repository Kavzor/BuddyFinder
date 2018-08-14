package com.zocom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class MainController {

	@RequestMapping(path = {"/home", "/"})
	public String handleHomeRequest() {
		return "index";
	}
	
	@RequestMapping(path = {"profile"})
	public ModelAndView handleProfileRequest() {
		ModelAndView model = new ModelAndView("profile");
		return model;
	}
	
	@RequestMapping(path = {"login"})
	public String handleLoginRequest() {
		return "login_form";
	}
}
