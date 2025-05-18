package com.springl1l2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Assignment2_and_3Controller {
	@Autowired
	private Indicator indicator;
	@GetMapping("/branch")
	public ModelAndView BankBranch() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("BankName", "South Bank Of India");
		ArrayList<Object> list = new ArrayList<>();
		list.add("Kormangala Branch");
		list.add("Kodathi Branch");
		list.add("EC Branch");
		list.add("Whitefield Branch");
		list.add("BTM Branch");
		list.add("Shree sai colony Branch");
		list.add("Mysore Branch");
		list.add("Sarjapur Branch");
		list.add("Shivpur Branch");
		list.add("Laxmi Colony Branch");
		modelView.addObject("Branch", list);
		modelView.setViewName("branch");
		return modelView;
	}
	@GetMapping("/services")
	public ModelAndView BankService() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("BankName", "South Bank Of India");
		modelView.addObject("BankService", "South Bank Service");
		ArrayList<Object> list = new ArrayList<>();
		list.add("Saving Account Services");
		list.add("Current Account Services");
		list.add("Customer Support Services");
		list.add("ATM Services");
		list.add("Card Block Services");
		list.add("Demat Accout Services");
		list.add("Auto Sweep Facility");
		list.add("Fixed Deposit");
		list.add("Mutual Funds");
		list.add("Locked Deposit");
		modelView.addObject("services", list);
		modelView.setViewName("service");
		return modelView;
	}
	
	@GetMapping("/health")
	public String checkHealth() {
		Health health =indicator.health();
		if(health.getStatus().equals(Status.UP)) {
			return "Health Check : UP";
		}else {
			return "Health Check : Down";
		}
	}

}
