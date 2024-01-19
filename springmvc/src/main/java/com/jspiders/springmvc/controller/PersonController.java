package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.PersonPOJO;
import com.jspiders.springmvc.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping("/add")
	public String addPage() {
		return "AddPerson";
	}

	@PostMapping("/add")
	public String addPerson(@RequestParam String name, ModelMap map) {
		PersonPOJO pojo = service.addPerson(name);
		// success
		if (pojo != null) {
			map.addAttribute("msg", "Data inserted successfully");
			return "AddPerson";
		}
		// failure
		map.addAttribute("msg", "Data not inserted");
		return "AddPerson";
	}

	@GetMapping("/search")
	public String searchPage() {
		return "SearchPerson";
	}

	@PostMapping("/search")
	public String searchPerson(@RequestParam String name, ModelMap map) {
		
		 List<PersonPOJO> pojo = (List<PersonPOJO>) service.allPersons(name);
		// success
		   if(pojo != null) {
			   map.addAttribute("persons", pojo);
			   return "SearchPerson";
		   }
		   //failure
		   map.addAttribute("msg","Student data does not exist");
		   return "SearchPerson";

	}

}
