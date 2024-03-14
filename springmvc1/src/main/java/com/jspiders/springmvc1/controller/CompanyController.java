package com.jspiders.springmvc1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc1.pojo.CompanyPOJO;
import com.jspiders.springmvc1.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;

	// Login Page Controller:========
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, ModelMap map,
			HttpSession session) {
		CompanyPOJO pojo = service.login(username, password);
		if (pojo != null) {
			session.setAttribute("login", pojo);
			session.setMaxInactiveInterval(300);
			return "Home";
		}
		else {
			map.addAttribute("msg", "Invalid Credentials. Try Again..!!");
			return "Login";
		}
	
	}

	// Create Page Controller:=======
	@GetMapping("/createCompany")
	public String createPage(ModelMap map) {
		List<CompanyPOJO> company = service.getCompany();
		if (company.isEmpty()) {
			return "CreateAccount";
		}
		map.addAttribute("msg", "Company Account already exists..!!");
		return "Login";
	}

	// Create Account Controller:========
	@PostMapping("/createCompany")
	public String createCompany(@RequestParam String username, @RequestParam String password, ModelMap map) {
		CompanyPOJO pojo = service.addAdmin(username, password);
		if (pojo != null) {
			map.addAttribute("msg", "Admin Account Created, Login now..!!");
			return "Login";
		}
		map.addAttribute("msg", "Invalid Credentials. Try Again..!!");
		return "CreateAccount";
	}

	// Logout Controller:========
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession Session) {
		Session.invalidate();
		map.addAttribute("msg", "Logged out Successfully..!!");
		return "Login";
	}

}
