package com.wipro.SA20449357.microservicesassignment1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.SA20449357.microservicesassignment1.entities.Patients;
import com.wipro.SA20449357.microservicesassignment1.entities.Services;
import com.wipro.SA20449357.microservicesassignment1.service.PatientService;
import com.wipro.SA20449357.microservicesassignment1.service.Servicespat;

@Controller
public class Assignment1_Controller {
	@Autowired
	private PatientService patientService;
	@Autowired
	private Servicespat service;
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("Home");
		return modelandview;
	}
	
	@GetMapping("/patients")
	public ModelAndView getAllPatients(Model model) {
		List<Patients> allPatients = patientService.getAllPatients();
		model.addAttribute("Patients", allPatients);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("Patients");
		return modelandview;
		
	}
	@GetMapping("/services")
	public ModelAndView getAllServices(Model model) {
		List<Services> allService = service.getAllService();
		model.addAttribute("Services", allService);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("Services");
		return modelandview;
	}

}
