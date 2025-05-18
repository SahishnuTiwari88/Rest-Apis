package com.thymeleaf.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(path = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("This is the about page");
		model.addAttribute("name", "Sarvesh Tiwari");
		return "about"; //about.html
	}
	
	//Handle iteration
	@GetMapping("iterate")
	public String iterateHandler(Model model) {
		List<String> name = List.of("Sarvesh","Shyam","Ram","Hanuman");
		model.addAttribute("name", name);
		
		return "iterate";
	}
	
	//Conditional handler using Elvis(ternary) operator
	@GetMapping("/condition")
	public String condition(Model m) {
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "F");//if-unless condition in thymeleaf
		List<Integer> list = List.of(22,23,34,56,78,90);//switch case checking
		m.addAttribute("mylist", list);
		
		return "condition";
	}
	
	//handler for including fragments
	@GetMapping("/service")
	public String serviceHandler(Model m) {
		m.addAttribute("title", "This is service handler");
		return "service";
	}
	
	//for new about handler
	@GetMapping("/aboutnew")
	public String newAbout() {
		return "aboutnew";
	}
	//contact us
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

}
