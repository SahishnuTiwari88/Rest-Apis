package com.springbootformvalidate.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootformvalidate.entities.FormData;

import jakarta.validation.Valid;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm(Model m) {
		m.addAttribute("formData", new FormData());//empty instance to show error
		return "form";
	}
	
	@PostMapping("/submit")
	public String submit(@Valid @ModelAttribute("formData") FormData formData, BindingResult result) { //after validation data are 
		//placed in binding result object
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(formData);
		return "submit";
		//after that we start working on validation part,for validation we need 2 libraries one is specification of bean validation
		//other is implementation of hibernate validator
		//apply validation on bean with help of annotation
	}

}
