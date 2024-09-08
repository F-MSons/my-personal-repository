package com.cpg.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpg.register.service.AdminService;

@Controller
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/home")
	public String home() {
	// ModelAndView model=new ModelAndView("home");
		return "home";
	}
	
	
}
