package com.springl1l2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.springl1l2.entity.Assignment4;
import com.springl1l2.service.Assignment4_Service;

@RestController
public class Assignment4_Controller {
	@Autowired
	private Assignment4_Service assignserv;
	
	@GetMapping("/register")
	public ModelAndView employeeForm() {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("register");
		return modelview;
	}
	
	@PostMapping("/saveemployee")
	public ModelAndView addEmployee(@ModelAttribute Assignment4 assign) {
		ModelAndView modelview = new ModelAndView();
		assignserv.addEmployee(assign);
		modelview.addObject("data", "Employee Page");
		modelview.setViewName("success");
		return modelview;
		
	}
	@GetMapping("/allemp")
	public ModelAndView getEmployees(Model model) {
		List<Assignment4> Employees = assignserv.getAllEmployees();
		model.addAttribute("emplist", Employees);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("getemployees");
		return modelandview;
		
	}
	@GetMapping("/empid/{id}")
	public ModelAndView getEmployee(@PathVariable("id") int eid,Model model) {
		
		Assignment4 employee = assignserv.getEmployeeById(eid);
		System.out.println(employee);
		model.addAttribute("emp", employee);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("empbyid");
		
		return modelandview;
	}

}
