package com.jspiders.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc1.pojo.CompanyPOJO;
import com.jspiders.springmvc1.pojo.EmployeePOJO;
import com.jspiders.springmvc1.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

//Home Page:======
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) CompanyPOJO company, ModelMap map) {
		if (company != null) {
			return "Home";
		}
		map.addAttribute("msg", "Please Login First..!");
		return "Login";
	}

//Add Employee:======
	// Add Form Controller:--
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) CompanyPOJO company, ModelMap map) {
		if (company != null) {
			return "AddEmployee";
		}
		map.addAttribute("msg", "Please Login First..!");
		return "Login";
	}

	// Add Data Controller:--
	@PostMapping("/add")
	public String addEmployee(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,
			@RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			EmployeePOJO pojo = service.addEmployee(name, email, mobile, address);
			// success
			if (pojo != null) {
				map.addAttribute("msg", "Data Inserted Successfully..!!");
				return "AddEmployee";
			}
			// Failure
			map.addAttribute("msg", "Data not Inserted..!!");
			return "AddEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

//Search Employee:=========
	// Search Page Controller:----
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) CompanyPOJO company, ModelMap map) {
		if (company != null) {
			return "SearchEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

	// Search Data Controller:----
	@PostMapping("/search")
	public String searchEmployee(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			EmployeePOJO pojo = service.searchEmployee(id);
			// success
			if (pojo != null) {
				map.addAttribute("employee", pojo);
				map.addAttribute("msg", "data found successfully..!!");
				return "SearchEmployee";
			}
			// failure
			map.addAttribute("msg", "Employee data does not exists..!!");
			return "SearchEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

//Update Employee:=====
	// Update Page Controller:----
	@GetMapping("/update")
	public String updatePage(ModelMap map, @SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			return "UpdateEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

	// Update View Controller:----
	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			EmployeePOJO pojo = service.searchEmployee(id);
			// success
			if (pojo != null) {
				map.addAttribute("employee", pojo);
				return "UpdateEmployee";
			}
			// failure
			map.addAttribute("msg", "Employee Data does not exists");
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			return "UpdateEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

	// Update Data Controller:----
	@PostMapping("/updateData")
	public String updateEmployee(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			EmployeePOJO pojo = service.updateEmployee(id, name, email, mobile, address);
			// success
			if (pojo != null) {
				map.addAttribute("msg", "Employee Data Updated Successfully..!!");
				List<EmployeePOJO> employees = service.allEmployees();
				return "UpdateEmployee";
			}
			// failure
			map.addAttribute("msg", "Employee data not Updated..!!");
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			return "UpdateEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

//Remove Employees:======
	// Remove Page Controller:----
	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			return "RemoveEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

	// Remove Data Controller:----
	@PostMapping("/remove")
	public String removeEmployee(@RequestParam int id, ModelMap map, CompanyPOJO company) {
		if (company != null) {
			EmployeePOJO pojo = service.removeEmployee(id);
			// success
			if (pojo != null) {
				List<EmployeePOJO> employees = service.allEmployees();
				map.addAttribute("employees", employees);
				map.addAttribute("msg", "Employee Data Deleted..!!");
				return "RemoveEmployee";
			}
			// failure
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			map.addAttribute("msg", "Employee data doen not exists..!!");
			return "RemoveEmployee";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

	// SearchAll Employees:======
	// SearchAll Page Controller:----
	@GetMapping("/searchAll")
	public String searchAll(ModelMap map, @SessionAttribute(name = "login", required = false) CompanyPOJO company) {
		if (company != null) {
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			return "DisplayAll";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}

	// SearchAll Data Controller:----
	@PostMapping("/searchAll")
	public String searchAll(@RequestParam int id, ModelMap map, CompanyPOJO company) {
		if (company != null) {
			List<EmployeePOJO> pojo = service.allEmployees();
			// success
			if (pojo != null) {
				List<EmployeePOJO> employees = service.allEmployees();
				map.addAttribute("employees", employees);
				return "DisplayAll";
			}
			// failure
			List<EmployeePOJO> employees = service.allEmployees();
			map.addAttribute("employees", employees);
			map.addAttribute("msg", "Employee data doen not exists..!!");
			return "DisplayAll";
		}
		map.addAttribute("msg", "Please Login First..!!");
		return "Login";
	}
}
