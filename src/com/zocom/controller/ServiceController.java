package com.zocom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services/*")
public class ServiceController {
	

	@Autowired
	private ApplicationContext context;

	//hello world restservices
	@GetMapping("/hello")
	public @ResponseBody String getMessage() {
		return context.getBean("getMessage").toString();
	}
}
